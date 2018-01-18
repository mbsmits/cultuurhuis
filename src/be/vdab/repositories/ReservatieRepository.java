package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import be.vdab.entities.Reservatie;

public final class ReservatieRepository extends AbstractRepository {

	private static final Logger LOGGER = Logger.getLogger(ReservatieRepository.class.getName());

	private static final String CREATE = "insert into reservaties(klantid, voorstellingsid, plaatsen) values (?, ?, ?)";

	public long create(Reservatie reservatie) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, reservatie.getKlant().getId());
			statement.setLong(2, reservatie.getVoorstelling().getId());
			statement.setLong(3, reservatie.getPlaatsen());
			statement.executeUpdate();
			long id;
			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				resultSet.next();
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException ex) {
			LOGGER.log(LOG_LEVEL, LOG_MESSAGE, ex);
			throw new RepositoryException(ex);
		}
	}

}
