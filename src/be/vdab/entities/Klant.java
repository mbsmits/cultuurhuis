package be.vdab.entities;

import java.io.Serializable;

public final class Klant extends Entiteit implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String voornaam;
	private final String familienaam;
	private final String straat;
	private final String huisnr;
	private final String postcode;
	private final String gemeente;
	private final String gebruikersnaam;
	private final String paswoord;

	public Klant(long id, String voornaam, String familienaam, String straat, String huisnr, String postcode,
			String gemeente, String gebruikersnaam, String paswoord) {
		super(id);
		this.voornaam = checkString(voornaam);
		this.familienaam = checkString(familienaam);
		this.straat = checkString(straat);
		this.huisnr = checkString(huisnr);
		this.postcode = checkString(postcode);
		this.gemeente = checkString(gemeente);
		this.gebruikersnaam = checkString(gebruikersnaam);
		this.paswoord = checkString(paswoord);
	}

	public Klant(String voornaam, String familienaam, String straat, String huisnr, String postcode, String gemeente,
			String gebruikersnaam, String paswoord) {
		super();
		this.voornaam = checkString(voornaam);
		this.familienaam = checkString(familienaam);
		this.straat = checkString(straat);
		this.huisnr = checkString(huisnr);
		this.postcode = checkString(postcode);
		this.gemeente = checkString(gemeente);
		this.gebruikersnaam = checkString(gebruikersnaam);
		this.paswoord = checkString(paswoord);
	}

	public String getVoornaam() {
		return voornaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisnr() {
		return huisnr;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public String getPaswoord() {
		return paswoord;
	}

	@Override
	public String toString() {
		return gebruikersnaam;
	}

}
