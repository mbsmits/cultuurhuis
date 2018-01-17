package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public final class Voorstelling implements Serializable, Comparable<Voorstelling> {
	
	private static final long serialVersionUID = 1L;
	private final long id;
	private final String titel;
	private final String uitvoerders;
	private final LocalDateTime datum;
	private final Genre genre;
	private final BigDecimal prijs;
	private final long vrijePlaatsen;
	
	Voorstelling(long id, String titel, String uitvoerders, LocalDateTime datum, Genre genre, BigDecimal prijs,
			long vrijePlaatsen) {
		this.id = id;
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
	
	public boolean isReserveerbaar() {
		return vrijePlaatsen > 0;
	}
	
	@Override
	public int compareTo(Voorstelling o) {
		return getTitel().compareTo(getTitel());
	}
	
	@Override
	public String toString() {
		return getTitel();
	}
	
	public Date getUtilDatum() {
		return Date.from(datum.atZone(ZoneId.systemDefault()).toInstant());
	}
}
