package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Genre;
import be.vdab.entities.Voorstelling;
import be.vdab.entities.VoorstellingBuilder;

public final class VoorstellingRepository extends AbstractRepository {

	private static final Logger LOGGER = Logger.getLogger(VoorstellingRepository.class.getName());
	private static final String BEGIN_SELECT = "select id, titel, uitvoerders, datum, prijs, vrijeplaatsen from voorstellingen ";
	private static final String FIND_BY_GENRE = BEGIN_SELECT + "where datum>=? and genreid=? order by datum";
	private static final String READ = BEGIN_SELECT + "where id=?";

	public List<Voorstelling> findByGenre(Genre genre) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(FIND_BY_GENRE)) {
			List<Voorstelling> voorstellingen = new ArrayList<>();
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setTimestamp(1, java.sql.Timestamp.valueOf(LocalDateTime.now()));
			statement.setLong(2, genre.getId());
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					voorstellingen.add(resultSetRijNaarVoorstelling(resultSet, genre));
				}
			}
			connection.commit();
			return voorstellingen;
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, "Probleem met database cultuurhuis", ex);
			throw new RepositoryException(ex);
		}
	}

	public Optional<Voorstelling> read(long id, Genre genre) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(READ)) {
			Optional<Voorstelling> voorstelling;
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					voorstelling = Optional.of(resultSetRijNaarVoorstelling(resultSet, genre));
				} else {
					voorstelling = Optional.empty();
				}
			}
			connection.commit();
			return voorstelling;
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, "Probleem met database cultuurhuis", ex);
			throw new RepositoryException(ex);
		}
	}

	private Voorstelling resultSetRijNaarVoorstelling(ResultSet resultSet, Genre genre) throws SQLException {
		VoorstellingBuilder builder = new VoorstellingBuilder();
		builder.setId(resultSet.getLong("id"));
		builder.setTitel(resultSet.getString("titel"));
		builder.setUitvoerders(resultSet.getString("uitvoerders"));
		builder.setDatum(resultSet.getTimestamp("datum").toLocalDateTime());
		builder.setGenre(genre);
		builder.setPrijs(resultSet.getBigDecimal("prijs"));
		builder.setVrijePlaatsen(resultSet.getLong("vrijeplaatsen"));
		return builder.build();
	}

}
