package be.vdab.entities;

public final class ReservatieBuilder extends Builder<Reservatie> {
	
	private long			id;
	private Klant			klant;
	private Voorstelling	voorstelling;
	private long			plaatsen;
	
	public ReservatieBuilder setId(long id) {
		this.id = id;
		return this;
	}
	
	public ReservatieBuilder setKlant(Klant klant) {
		this.klant = klant;
		return this;
	}
	
	public ReservatieBuilder setVoorstelling(Voorstelling voorstelling) {
		this.voorstelling = voorstelling;
		return this;
	}
	
	public ReservatieBuilder setVrijePlaatsen(long plaatsen) {
		this.plaatsen = plaatsen;
		return this;
	}
	
	@Override
	public Reservatie build() {
		return new Reservatie(id, klant, voorstelling, plaatsen);
	}
}
