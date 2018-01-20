package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import be.vdab.entities.Reservatie;

public final class ReservatieRepository extends AbstractRepository {

	private static final Logger LOGGER = Logger.getLogger(ReservatieRepository.class.getName());

	private static final String UPDATE = "update voorstellingen set vrijeplaatsen=vrijeplaatsen-? where id=?";
	private static final String INSERT = "insert into reservaties(klantid, voorstellingsid, plaatsen) values (?, ?, ?)";

	public void maakAan(Reservatie reservatie) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement update = connection.prepareStatement(UPDATE);
				PreparedStatement insert = connection.prepareStatement(INSERT)) {
			update.setLong(1, reservatie.getPlaatsen());
			update.setLong(2, reservatie.getVoorstellingId());
			insert.setLong(1, reservatie.getKlantId());
			insert.setLong(2, reservatie.getVoorstellingId());
			insert.setLong(3, reservatie.getPlaatsen());
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			connection.setAutoCommit(false);
			update.executeUpdate();
			insert.executeUpdate();
			connection.commit();
		} catch (SQLException ex) {
			LOGGER.log(LOG_LEVEL, LOG_MESSAGE, ex);
			throw new RepositoryException(ex);
		}
	}

}
