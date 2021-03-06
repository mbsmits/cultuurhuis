package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import be.vdab.entities.Klant;

public final class KlantRepository extends EntiteitRepository {

	private static final Logger LOGGER = Logger.getLogger(KlantRepository.class.getName());

	private static final String FIND_BY_GEBRUIKERSNAAM_AND_PASWOORD = "select id, voornaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord "
			+ " from klanten where gebruikersnaam=? and paswoord=?";

	private static final String CREATE = "insert into klanten(voornaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord ) values (?, ?, ?, ?, ?, ?, ?, ?)";

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

	public void maakAan(Klant klant) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(CREATE)) {
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
			connection.commit();
		} catch (SQLException ex) {
			LOGGER.log(LOG_LEVEL, LOG_MESSAGE, ex);
			throw new RepositoryException(ex);
		}
	}

	private Klant resultSetRijNaarKlant(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("id");
		String voornaam = resultSet.getString("voornaam");
		String familienaam = resultSet.getString("familienaam");
		String straat = resultSet.getString("straat");
		String huisnr = resultSet.getString("huisnr");
		String postcode = resultSet.getString("postcode");
		String gemeente = resultSet.getString("gemeente");
		String gebruikersnaam = resultSet.getString("gebruikersnaam");
		String paswoord = resultSet.getString("paswoord");
		return new Klant(id, voornaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord);
	}

}
