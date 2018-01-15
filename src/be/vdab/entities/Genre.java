package be.vdab.entities;

import java.io.Serializable;
import java.util.Objects;

public final class Genre extends Entiteit implements Serializable, Comparable<Genre> {
	
	private static final long serialVersionUID = 1L;
	
	private final long		id;
	private final String	naam;
	
	Genre(long id, String naam) {
		this.id = checkGeheelGetal(id);
		this.naam = Objects.requireNonNull(naam);
	}
	
	public long getId() {
		return id;
	}
	
	public String getNaam() {
		return naam;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this instanceof Genre) {
			Genre other = (Genre) obj;
			return Objects.equals(getId(), other.getId()) && Objects.equals(getNaam(), other.getNaam());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return getNaam();
	}
	
	@Override
	public int compareTo(Genre other) {
		return getNaam().compareTo(getNaam());
	}
	
}
