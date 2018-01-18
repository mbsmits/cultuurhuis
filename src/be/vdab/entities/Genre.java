package be.vdab.entities;

import java.io.Serializable;

public final class Genre extends Entiteit implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String naam;

	public Genre(long id, String naam) {
		super(id);
		this.naam = checkString(naam);
	}

	public String getNaam() {
		return naam;
	}

	@Override
	public String toString() {
		return naam;
	}
	
}
