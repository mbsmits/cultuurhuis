package be.vdab.entities;

public final class ReservatieBuilder extends Builder<Reservatie> {
	
	private long id;
	private Klant klant;
	private Voorstelling voorstelling;
	private long plaatsen;
	
	public long getId() {
		return id;
	}
	
	public Klant getKlant() {
		return klant;
	}
	
	public Voorstelling getVoorstelling() {
		return voorstelling;
	}
	
	public long getPlaatsen() {
		return plaatsen;
	}
	
	public ReservatieBuilder setId(long id) {
		this.id = checkLong(id);
		return this;
	}
	
	public ReservatieBuilder setKlant(Klant klant) {
		this.klant = checkKlant(klant);
		return this;
	}
	
	public ReservatieBuilder setVoorstelling(Voorstelling voorstelling) {
		this.voorstelling = checkVoorstelling(voorstelling);
		return this;
	}
	
	public ReservatieBuilder setPlaatsen(long plaatsen) {
		this.plaatsen = checkLong(plaatsen);
		return this;
	}
	
	@Override
	public Reservatie build() {
		return new Reservatie(id, klant, voorstelling, plaatsen);
	}
	
}
