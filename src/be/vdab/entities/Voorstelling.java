package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public final class Voorstelling extends Entiteit implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String titel;
	private final String uitvoerders;
	private final LocalDateTime datum;
	private final Genre genre;
	private final BigDecimal prijs;
	private final long vrijePlaatsen;

	public Voorstelling(long id, String titel, String uitvoerders, LocalDateTime datum, Genre genre, BigDecimal prijs,
			long vrijePlaatsen) {
		super(id);
		this.titel = checkString(titel);
		this.uitvoerders = checkString(uitvoerders);
		this.datum = Objects.requireNonNull(datum);
		this.genre = Objects.requireNonNull(genre);
		this.prijs = Objects.requireNonNull(prijs);
		this.vrijePlaatsen = checkLong(vrijePlaatsen);
	}
	
	public String getTitel() {
		return titel;
	}

	public String getUitvoerders() {
		return uitvoerders;
	}

	public LocalDateTime getDatum() {
		return datum;
	}

	public Genre getGenre() {
		return genre;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public long getVrijePlaatsen() {
		return vrijePlaatsen;
	}

	public boolean isReserveerbaar() {
		return vrijePlaatsen > 0;
	}

	public Date getUtilDatum() {
		return Date.from(datum.atZone(ZoneId.systemDefault()).toInstant());
	}

	@Override
	public String toString() {
		return titel + " door " + uitvoerders + " op " + datum;
	}

}
