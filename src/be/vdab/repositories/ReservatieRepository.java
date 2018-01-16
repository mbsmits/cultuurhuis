package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.logging.Logger;

import be.vdab.entities.Klant;
import be.vdab.entities.Reservatie;
import be.vdab.entities.ReservatieBuilder;
import be.vdab.entities.Voorstelling;

public final class ReservatieRepository extends AbstractRepository {
	
	private static final Logger LOGGER = Logger.getLogger(ReservatieRepository.class.getName());
	private static final String ID = "id";
	private static final String KLANTID = "klantid";
	private static final String VOORSTELLINGSID = "voorstellingsid";
	private static final String PLAATSEN = "plaatsen";
	private static final String BEGIN_SELECT = String.format("select %s, %s, %s, %s from reservaties ", ID, KLANTID,
			VOORSTELLINGSID, PLAATSEN);
	private static final String READ = BEGIN_SELECT + String.format("where %s=?", ID);
	private static final String CREATE = String.format("insert into reservaties(%s, %s, %s) values (?, ?, ?)", KLANTID,
			VOORSTELLINGSID, PLAATSEN);
	public static final ReservatieRepository INSTANCE = new ReservatieRepository();
	
	private ReservatieRepository() {
	}
	
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
			log(ex, LOGGER);
			throw new RepositoryException(ex);
		}
	}
	
	public Reservatie create(ReservatieBuilder builder) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, builder.getKlant().getId());
			statement.setLong(2, builder.getVoorstelling().getId());
			statement.setLong(3, builder.getPlaatsen());
			statement.executeUpdate();
			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				resultSet.next();
				builder.setId(resultSet.getLong(1));
			}
			connection.commit();
			return builder.build();
		} catch (SQLException ex) {
			log(ex, LOGGER);
			throw new RepositoryException(ex);
		}
	}
	
	private Reservatie resultSetRijNaarReservatie(ResultSet resultSet, Voorstelling voorstelling, Klant klant)
			throws SQLException {
		ReservatieBuilder builder = new ReservatieBuilder();
		builder.setId(resultSet.getLong(ID));
		builder.setVoorstelling(voorstelling);
		builder.setKlant(klant);
		builder.setPlaatsen(resultSet.getLong(PLAATSEN));
		return builder.build();
	}
	
}
