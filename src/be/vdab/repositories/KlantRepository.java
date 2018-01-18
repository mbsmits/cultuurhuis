package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import be.vdab.entities.Klant;

public final class KlantRepository extends AbstractRepository {

	private static final Logger LOGGER = Logger.getLogger(KlantRepository.class.getName());

	private static final String FIND_BY_GEBRUIKERSNAAM_AND_PASWOORD = "select voornaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord "
			+ " from klanten where gebruikersnaam=? and paswoord=?";

	private static final String CREATE = "insert into klanten(voornaam, familienaam, straat, huisnr, postcode, gebruikersnaam, paswoord ) values (?, ?, ?, ?, ?, ?, ?, ?)";


	public Klant findByGebruikersnaamAndPaswoord(String gebruikersnaam, String paswoord) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(FIND_BY_GEBRUIKERSNAAM_AND_PASWOORD)) {
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setString(1, gebruikersnaam);
			statement.setString(2, paswoord);
			Klant klant;
			try (ResultSet resultSet = statement.executeQuery()) {
				resultSet.next();
				klant = resultSetRijNaarKlant(resultSet);
			}
			connection.commit();
			return klant;
		} catch (SQLException ex) {
			LOGGER.log(LOG_LEVEL, LOG_MESSAGE, ex);
			throw new RepositoryException(ex);
		}
	}

	public long maakAan(Klant klant) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setString(1, klant.getVoornaam());
			statement.setString(2, klant.getFamilienaam());
			statement.setString(3, klant.getStraat());
			statement.setString(4, klant.getHuisnr());
			statement.setString(5, klant.getPostcode());
			statement.setString(6, klant.getGemeente());
			statement.setString(7, klant.getGebruikersnaam());
			statement.setString(8, klant.getPaswoord());
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

	private Klant resultSetRijNaarKlant(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("id");
		String voornaam = resultSet.getString("");
		String familienaam = resultSet.getString("");
		String straat = resultSet.getString("");
		String huisnr = resultSet.getString("");
		String postcode = resultSet.getString("");
		String gemeente = resultSet.getString("");
		String gebruikersnaam = resultSet.getString("");
		String paswoord = resultSet.getString("");
		return new Klant(id, voornaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam,paswoord);
	}

}
