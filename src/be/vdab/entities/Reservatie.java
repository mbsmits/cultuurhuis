package be.vdab.entities;

import java.io.Serializable;
import java.util.Objects;

public final class Reservatie extends Entiteit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Klant klant;
	private final Voorstelling voorstelling;
	private final long plaatsen;
	
	public Reservatie(long id, Klant klant, Voorstelling voorstelling, long plaatsen) {
		super(id);
		this.klant = Objects.requireNonNull(klant);
		this.voorstelling = Objects.requireNonNull(voorstelling);
		this.plaatsen = checkLong(plaatsen);
	}
	
	public Reservatie(Klant klant, Voorstelling voorstelling, long plaatsen) {
		super();
		this.klant = Objects.requireNonNull(klant);
		this.voorstelling = Objects.requireNonNull(voorstelling);
		this.plaatsen = checkLong(plaatsen);
	}
	
	public Reservatie(Voorstelling voorstelling, long plaatsen) {
		super();
		this.klant = null;
		this.voorstelling = Objects.requireNonNull(voorstelling);
		this.plaatsen = checkLong(plaatsen);
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
	
	@Override
	public String toString() {
		return "reservatie van " + klant + " voor " + voorstelling;
	}
	
}
