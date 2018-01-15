package be.vdab.entities;

import java.io.Serializable;
import java.util.Objects;

public final class Klant extends Entiteit implements Serializable, Comparable<Klant> {
	
	private static final long serialVersionUID = 1L;
	
	private final long		id;
	private final String	voornaam;
	private final String	familienaam;
	private final String	straat;
	private final String	huisnr;
	private final String	postcode;
	private final String	gemeente;
	private final String	gebruikersnaam;
	private final String	paswoord;
	
	Klant(long id, String voornaam, String familienaam, String straat, String huisnr, String postcode, String gemeente,
			String gebruikersnaam, String paswoord) {
		this.id = checkGeheelGetal(id);
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.straat = straat;
		this.huisnr = huisnr;
		this.postcode = postcode;
		this.gemeente = gemeente;
		this.gebruikersnaam = gebruikersnaam;
		this.paswoord = paswoord;
	}
	
	public long getId() {
		return id;
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
	public int hashCode() {
		return Objects.hash(getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this instanceof Klant) {
			Klant other = (Klant) obj;
			return Objects.equals(getId(), other.getId());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return getGebruikersnaam();
	}
	
	@Override
	public int compareTo(Klant other) {
		return getGebruikersnaam().compareTo(getGebruikersnaam());
	}
	
}
