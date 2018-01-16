package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Klant;
import be.vdab.entities.KlantBuilder;

public final class KlantRepository extends AbstractRepository {
	
	private static final Logger			LOGGER								= Logger
			.getLogger(KlantRepository.class.getName());
	private static final String			BEGIN_SELECT						= "select voonaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord ";
	private static final String			FIND_BY_ID							= BEGIN_SELECT + "where id=?";
	private static final String			FIND_BY_GEBRUIKERSNAAM_AND_PASWOORD	= BEGIN_SELECT
			+ "where gebruikersnaam=? and paswoord=?";
	private static final String			CREATE								= "insert into klanten(voonaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final KlantRepository	INSTANCE							= new KlantRepository();
	
	private KlantRepository() {
	}
	
	public Optional<Klant> read(String gebruikersnaam, String paswoord) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(FIND_BY_GEBRUIKERSNAAM_AND_PASWOORD)) {
			Optional<Klant> klant;
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setString(1, gebruikersnaam);
			statement.setString(2, paswoord);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					klant = Optional.of(resultSetRijNaarKlant(resultSet));
				} else {
					klant = Optional.empty();
				}
			}
			connection.commit();
			return klant;
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, "Probleem met database cultuurhuis", ex);
			throw new RepositoryException(ex);
		}
	}
	
	public Optional<Klant> read(long id) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
			Optional<Klant> klant;
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					klant = Optional.of(resultSetRijNaarKlant(resultSet));
				} else {
					klant = Optional.empty();
				}
			}
			connection.commit();
			return klant;
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, "Probleem met database cultuurhuis", ex);
			throw new RepositoryException(ex);
		}
	}
	
	public Klant create(KlantBuilder builder) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setString(1, builder.getVoornaam());
			statement.setString(2, builder.getFamilienaam());
			statement.setString(3, builder.getStraat());
			statement.setString(4, builder.getHuisnr());
			statement.setString(5, builder.getPostcode());
			statement.setString(6, builder.getGemeente());
			statement.setString(7, builder.getGebruikersnaam());
			statement.setString(8, builder.getPaswoord());
			statement.executeUpdate();
			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				resultSet.next();
				builder.setId(resultSet.getLong(1));
			}
			connection.commit();
			return builder.build();
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE, "Probleem met database cultuurhuis", ex);
			throw new RepositoryException(ex);
		}
	}
	
	private Klant resultSetRijNaarKlant(ResultSet resultSet) throws SQLException {
		KlantBuilder builder = new KlantBuilder();
		builder.setId(resultSet.getLong("id"));
		builder.setVoornaam(resultSet.getString("voornaam"));
		builder.setFamilienaam(resultSet.getString("familienaam"));
		builder.setStraat(resultSet.getString("straat"));
		builder.setHuisnr(resultSet.getString("huisnr"));
		builder.setPostcode(resultSet.getString("postcode"));
		builder.setGemeente(resultSet.getString("gemeente"));
		builder.setGebruikersnaam(resultSet.getString("gebruikersnaam"));
		builder.setPaswoord(resultSet.getString("paswoord"));
		return builder.build();
	}
	
}
