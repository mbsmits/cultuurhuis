package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Voorstelling extends Entiteit implements Serializable, Comparable<Voorstelling> {
	
	private static final long serialVersionUID = 1L;
	
	// TODO: builder?
	
	private final long			id;
	private final String		titel;
	private final String		uitvoerders;
	private final LocalDateTime	datum;			// TODO: moet dit niet LocalDate zijn?
	private final Genre			genre;
	private final BigDecimal	prijs;
	private final long			vrijePlaatsen;
	
	public Voorstelling(long id, String titel, String uitvoerders, LocalDateTime datum, Genre genre, BigDecimal prijs,
			long vrijePlaatsen) {
		this.id = checkGeheelGetal(id);
		this.titel = titel;
		this.uitvoerders = uitvoerders;
		this.datum = datum;
		this.genre = genre;
		this.prijs = prijs;
		this.vrijePlaatsen = vrijePlaatsen;
	}
	
	public long getId() {
		return id;
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
	
	@Override
	public int compareTo(Voorstelling o) {
		return getTitel().compareTo(getTitel());
	}
	
	@Override
	public String toString() {
		return getTitel();
	}
	
}
