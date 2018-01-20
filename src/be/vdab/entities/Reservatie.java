package be.vdab.entities;

import java.io.Serializable;
import java.util.Objects;

public final class Reservatie extends Entiteit implements Serializable {

	private static final long serialVersionUID = 1L;

	private long klantId;
	private final Voorstelling voorstelling;
	private final long plaatsen;

	public Reservatie(Voorstelling voorstelling, long plaatsen) {
		super();
		this.voorstelling = Objects.requireNonNull(voorstelling);
		this.plaatsen = checkLong(plaatsen);
	}

	public long getKlantId() {
		return klantId;
	}

	public long getVoorstellingId() {
		return voorstelling.getId();
	}

	public Voorstelling getVoorstelling() {
		return voorstelling;
	}

	public long getPlaatsen() {
		return plaatsen;
	}

	public void setKlantId(long klantId) {
		this.klantId = checkLong(klantId);
	}

}
