package be.vdab.repositories;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import be.vdab.entities.Voorstelling;

public final class VoorstellingRepository extends EntiteitRepository {
	
	private static final Logger LOGGER = Logger.getLogger(VoorstellingRepository.class.getName());
	private static final String FIND_BY_GENRE = "select id, titel, uitvoerders, datum, genreid, prijs, vrijeplaatsen "
			+ "from voorstellingen where genreid=? and datum>=? order by datum";
	private static final String FIND_BY_ID = "select id, titel, uitvoerders, datum, genreid, prijs, vrijeplaatsen "
			+ "from voorstellingen where id=?";
	
	public List<Voorstelling> findByGenreId(long genreid) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(FIND_BY_GENRE)) {
			List<Voorstelling> voorstellingen = new ArrayList<>();
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, genreid);
			statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					voorstellingen.add(resultSetRijNaarVoorstelling(resultSet));
				}
			}
			connection.commit();
			return Collections.unmodifiableList(voorstellingen);
		} catch (SQLException ex) {
			LOGGER.log(LOG_LEVEL, LOG_MESSAGE, ex);
			throw new RepositoryException(ex);
		}
	}
	
	public Voorstelling findById(long id) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, id);
			Voorstelling voorstelling;
			try (ResultSet resultSet = statement.executeQuery()) {
				resultSet.next();
				voorstelling = resultSetRijNaarVoorstelling(resultSet);
			}
			connection.commit();
			return voorstelling;
		} catch (SQLException ex) {
			LOGGER.log(LOG_LEVEL, LOG_MESSAGE, ex);
			throw new RepositoryException(ex);
		}
	}
	
	private Voorstelling resultSetRijNaarVoorstelling(ResultSet resultSet) throws SQLException {
		long voorstellingenId = resultSet.getLong("id");
		String titel = resultSet.getString("titel");
		String uitvoerders = resultSet.getString("uitvoerders");
		LocalDateTime datum = resultSet.getTimestamp("datum").toLocalDateTime();
		long genreId = resultSet.getLong("genreid");
		BigDecimal prijs = resultSet.getBigDecimal("prijs");
		long vrijePlaatsen = resultSet.getLong("vrijeplaatsen");
		return new Voorstelling(voorstellingenId, titel, uitvoerders, datum, genreId, prijs, vrijePlaatsen);
	}
}
