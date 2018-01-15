package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Klant;
import be.vdab.entities.Reservatie;
import be.vdab.entities.ReservatieBuilder;
import be.vdab.entities.Voorstelling;

public final class ReservatieRepository extends AbstractRepository {

	private static final Logger LOGGER = Logger.getLogger(ReservatieRepository.class.getName());
	private static final String BEGIN_SELECT = "select id, klantid, voorstellingsid, plaatsen from reservaties ";
	private static final String READ = BEGIN_SELECT + "where id=?";

	public Optional<Reservatie> read(long id, Voorstelling voorstelling, Klant klant) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(READ)) {
			Optional<Reservatie> reservatie;
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					reservatie = Optional.of(resultSetRijNaarReservatie(resultSet, voorstelling, klant));
				} else {
					reservatie = Optional.empty();
				}
			}
			connection.commit();
			return reservatie;
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, "Probleem met database cultuurhuis", ex);
			throw new RepositoryException(ex);
		}
	}

	private Reservatie resultSetRijNaarReservatie(ResultSet resultSet, Voorstelling voorstelling, Klant klant)
			throws SQLException {
		ReservatieBuilder builder = new ReservatieBuilder();
		builder.setId(resultSet.getLong("id"));
		builder.setVoorstelling(voorstelling);
		builder.setKlant(klant);
		builder.setPlaatsen(resultSet.getLong("plaatsen"));
		return builder.build();
	}

}
