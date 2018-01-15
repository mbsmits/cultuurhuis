package be.vdab.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class VoorstellingBuilder extends Builder<Voorstelling> {
	
	private long			id;
	private String			titel;
	private String			uitvoerders;
	private LocalDateTime	datum;
	private Genre			genre;
	private BigDecimal		prijs;
	private long			vrijePlaatsen;
	
	public VoorstellingBuilder setId(long id) {
		this.id = id;
		return this;
	}
	
	public VoorstellingBuilder setTitel(String titel) {
		this.titel = titel;
		return this;
	}
	
	public VoorstellingBuilder setUitvoerders(String uitvoerders) {
		this.uitvoerders = uitvoerders;
		return this;
	}
	
	public VoorstellingBuilder setDatum(LocalDateTime datum) {
		this.datum = datum;
		return this;
	}
	
	public VoorstellingBuilder setGenre(Genre genre) {
		this.genre = genre;
		return this;
	}
	
	public VoorstellingBuilder setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
		return this;
	}
	
	public VoorstellingBuilder setVrijePlaatsen(long vrijePlaatsen) {
		this.vrijePlaatsen = vrijePlaatsen;
		return this;
	}
	
	@Override
	public Voorstelling build() {
		return new Voorstelling(id, titel, uitvoerders, datum, genre, prijs, vrijePlaatsen);
	}
}
