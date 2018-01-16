package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import be.vdab.entities.Genre;
import be.vdab.entities.Voorstelling;
import be.vdab.entities.VoorstellingBuilder;

public final class VoorstellingRepository extends AbstractRepository {
	
	private static final Logger LOGGER = Logger.getLogger(VoorstellingRepository.class.getName());
	private static final String ID = "id";
	private static final String TITEL = "titel";
	private static final String UITVOERDERS = "uitvoerders";
	private static final String DATUM = "datum";
	private static final String GENREID = "genreid";
	private static final String PRIJS = "prijs";
	private static final String VRIJEPLAATSEN = "vrijeplaatsen";
	private static final String BEGIN_SELECT = String.format("select %s, %s, %s, %s, %s, %s from voorstellingen ", ID,
			TITEL, UITVOERDERS, DATUM, PRIJS, VRIJEPLAATSEN);
	private static final String FIND_BY_GENRE = BEGIN_SELECT
			+ String.format("where %s>=? and %s=? order by %s", DATUM, GENREID, DATUM);
	private static final String READ = BEGIN_SELECT + String.format("where %s=?", ID);
	public static final VoorstellingRepository INSTANCE = new VoorstellingRepository();
	
	private VoorstellingRepository() {
	}
	
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
			log(ex, LOGGER);
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
			log(ex, LOGGER);
			throw new RepositoryException(ex);
		}
	}
	
	private Voorstelling resultSetRijNaarVoorstelling(ResultSet resultSet, Genre genre) throws SQLException {
		VoorstellingBuilder builder = new VoorstellingBuilder();
		builder.setId(resultSet.getLong(ID));
		builder.setTitel(resultSet.getString(TITEL));
		builder.setUitvoerders(resultSet.getString(UITVOERDERS));
		builder.setDatum(resultSet.getTimestamp(DATUM).toLocalDateTime());
		builder.setGenre(genre);
		builder.setPrijs(resultSet.getBigDecimal(PRIJS));
		builder.setVrijePlaatsen(resultSet.getLong(VRIJEPLAATSEN));
		return builder.build();
	}
	
}
