package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import be.vdab.entities.Genre;

public final class GenreRepository extends AbstractRepository {

	private static final Logger LOGGER = Logger.getLogger(GenreRepository.class.getName());

	private static final String FIND_ALL = "select id, naam from genres";
	private static final String FIND_BY_ID = "select id, naam from genres where id=?";
	
	public List<Genre> findAll() {
		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
			List<Genre> genres = new ArrayList<>();
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
				while (resultSet.next()) {
					genres.add(resultSetRijNaarGenre(resultSet));
				}
			}
			connection.commit();
			return Collections.unmodifiableList(genres);
		} catch (SQLException ex) {
			LOGGER.log(LOG_LEVEL, LOG_MESSAGE, ex);
			throw new RepositoryException(ex);
		}
	}

	public Genre findById(long id) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, id);
			Genre genre;
			try (ResultSet resultSet = statement.executeQuery()) {
				resultSet.next();
				genre = resultSetRijNaarGenre(resultSet);
			}
			connection.commit();
			return genre;
		} catch (SQLException ex) {
			LOGGER.log(LOG_LEVEL, LOG_MESSAGE, ex);
			throw new RepositoryException(ex);
		}
	}	
	
	private Genre resultSetRijNaarGenre(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("id");
		String naam = resultSet.getString("naam");
		return new Genre(id, naam);
	}
}
