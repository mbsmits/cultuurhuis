package be.vdab.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Genre;
import be.vdab.entities.GenreBuilder;

public final class GenreRepository extends AbstractRepository {
	
	private static final Logger	LOGGER			= Logger.getLogger(GenreRepository.class.getName());
	private static final String	BEGIN_SELECT	= "select id, naam from genres ";
	private static final String	FIND_ALL		= BEGIN_SELECT + "order by naam";
	
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
			return genres;
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, "Probleem met database cultuurhuis", ex);
			throw new RepositoryException(ex);
		}
	}
	
	private Genre resultSetRijNaarGenre(ResultSet resultSet) throws SQLException {
		GenreBuilder builder = new GenreBuilder();
		builder.setId(resultSet.getLong("id"));
		builder.setNaam(resultSet.getString("naam"));
		return builder.build();
	}
}
