package be.vdab.entities;

import java.io.Serializable;

public final class Reservatie extends Entiteit implements Serializable {

	private static final long serialVersionUID = 1L;

	private long klantId;
	private final long voorstellingId;
	private final long plaatsen;

	public Reservatie(long voorstellingId, long plaatsen) {
		super();
		this.voorstellingId = checkLong(voorstellingId);
		this.plaatsen = checkLong(plaatsen);
	}

	public long getKlantId() {
		return klantId;
	}

	public long getVoorstellingId() {
		return voorstellingId;
	}

	public long getPlaatsen() {
		return plaatsen;
	}

	public void setKlantId(long klantId) {
		this.klantId = checkLong(klantId);
	}

}
