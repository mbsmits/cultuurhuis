package be.vdab.entities;

import java.io.Serializable;
import java.util.Objects;

public final class Reservatie extends Entiteit implements Serializable {

	private static final long serialVersionUID = 1L;

	private Klant klant;
	private final Voorstelling voorstelling;
	private final long plaatsen;

	public Reservatie(Voorstelling voorstelling, long plaatsen) {
		super();
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

	public void setKlant(Klant klant) {
		this.klant = Objects.requireNonNull(klant);
	}

	@Override
	public String toString() {
		return "reservatie van " + klant + " voor " + voorstelling;
	}

}
