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
	
	public KlantBuilder setId(long id) {
		this.id = id;
		return this;
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
	
	public KlantBuilder setVoornaam(String voornaam) {
		this.voornaam = voornaam;
		return this;
	}
	
	public KlantBuilder setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
		return this;
	}
	
	public KlantBuilder setStraat(String straat) {
		this.straat = straat;
		return this;
	}
	
	public KlantBuilder setHuisnr(String huisnr) {
		this.huisnr = huisnr;
		return this;
	}
	
	public KlantBuilder setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}
	
	public KlantBuilder setGemeente(String gemeente) {
		this.gemeente = gemeente;
		return this;
	}
	
	public KlantBuilder setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
		return this;
	}
	
	public KlantBuilder setPaswoord(String paswoord) {
		this.paswoord = paswoord;
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
