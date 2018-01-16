package be.vdab.entities;

import java.io.Serializable;
import java.util.Objects;

public final class Reservatie extends Entiteit implements Serializable, Comparable<Reservatie> {
	
	private static final long serialVersionUID = 1L;
	
	private final long id;
	private final Klant klant;
	private final Voorstelling voorstelling;
	private final long plaatsen;
	
	Reservatie(long id, Klant klant, Voorstelling voorstelling, long plaatsen) {
		this.id = id;
		this.klant = klant;
		this.voorstelling = voorstelling;
		this.plaatsen = plaatsen;
	}
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this instanceof Reservatie) {
			Genre other = (Genre) obj;
			return Objects.equals(getId(), other.getId());
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Reservatie other) {
		int compareVoorstellingen = getVoorstelling().compareTo(other.getVoorstelling());
		return compareVoorstellingen != 0 ? compareVoorstellingen : getKlant().compareTo(other.getKlant());
	}
	
	@Override
	public String toString() {
		return getVoorstelling() + " voor " + getKlant();
	}
	
}
