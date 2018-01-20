package be.vdab.entities;

import java.io.Serializable;

public final class Genre extends Entiteit implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private final String naam;

	public Genre(long id, String naam) {
		this.id = checkLong(id);
		this.naam = checkString(naam);
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

}
