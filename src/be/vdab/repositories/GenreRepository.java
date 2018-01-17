package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

import be.vdab.entities.Genre;
import be.vdab.entities.GenreBuilder;

public final class GenreRepository extends AbstractRepository {
	
	private static final Logger LOGGER = Logger.getLogger(GenreRepository.class.getName());
	private static final String ID = "id";
	private static final String NAAM = "naam";
	private static final String BEGIN_SELECT = String.format("select %s, %s from genres ", ID, NAAM);
	private static final String FIND_ALL = BEGIN_SELECT + String.format("order by %s", NAAM);
	private static final String READ = BEGIN_SELECT + String.format("where %s=?", ID);
	public static final GenreRepository INSTANCE = new GenreRepository();
	
	private GenreRepository() {
	}
	
	public SortedSet<Genre> findAll() {
		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
			SortedSet<Genre> genres = new TreeSet<>();
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
				while (resultSet.next()) {
					genres.add(resultSetRijNaarGenre(resultSet));
				}
			}
			connection.commit();
			return Collections.unmodifiableSortedSet(genres);
		} catch (SQLException ex) {
			log(ex, LOGGER);
			throw new RepositoryException(ex);
		}
	}
	
	public Optional<Genre> read(long id) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(READ)) {
			Optional<Genre> genre;
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					genre = Optional.of(resultSetRijNaarGenre(resultSet));
				} else {
					genre = Optional.empty();
				}
			}
			connection.commit();
			return genre;
		} catch (SQLException ex) {
			log(ex, LOGGER);
			throw new RepositoryException(ex);
		}
	}
	
	private Genre resultSetRijNaarGenre(ResultSet resultSet) throws SQLException {
		GenreBuilder builder = new GenreBuilder();
		builder.setId(resultSet.getLong(ID));
		builder.setNaam(resultSet.getString(NAAM));
		return builder.build();
	}
}
