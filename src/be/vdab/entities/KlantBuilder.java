package be.vdab.entities;

public final class KlantBuilder extends Builder<Klant> {
	
	private long	id;
	private String	voornaam;
	private String	familienaam;
	private String	straat;
	private String	huisnr;
	private String	postcode;
	private String	gemeente;
	private String	gebruikersnaam;
	private String	paswoord;
	
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
	
	public KlantBuilder setId(long id) {
		this.id = checkLong(id);
		return this;
	}
	
	public KlantBuilder setVoornaam(String voornaam) {
		this.voornaam = checkString(voornaam);
		return this;
	}
	
	public KlantBuilder setFamilienaam(String familienaam) {
		this.familienaam = checkString(familienaam);
		return this;
	}
	
	public KlantBuilder setStraat(String straat) {
		this.straat = checkString(straat);
		return this;
	}
	
	public KlantBuilder setHuisnr(String huisnr) {
		this.huisnr = checkString(huisnr);
		return this;
	}
	
	public KlantBuilder setPostcode(String postcode) {
		this.postcode = checkString(postcode);
		return this;
	}
	
	public KlantBuilder setGemeente(String gemeente) {
		this.gemeente = checkString(gemeente);
		return this;
	}
	
	public KlantBuilder setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = checkString(gebruikersnaam);
		return this;
	}
	
	public KlantBuilder setPaswoord(String paswoord) {
		this.paswoord = checkString(paswoord);
		return this;
	}
	
	public KlantBuilder copy(Klant klant) {
		setId(klant.getId());
		setVoornaam(klant.getVoornaam());
		setFamilienaam(klant.getFamilienaam());
		setStraat(klant.getStraat());
		setHuisnr(klant.getHuisnr());
		setPostcode(klant.getPostcode());
		setGemeente(klant.getGemeente());
		setGebruikersnaam(klant.getGebruikersnaam());
		setPaswoord(klant.getPaswoord());
		return this;
	}
	
	@Override
	public Klant build() {
		return new Klant(id, voornaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord);
	}
}
