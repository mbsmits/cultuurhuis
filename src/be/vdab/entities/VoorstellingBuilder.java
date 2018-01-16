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
		this.id = checkLong(id);
		return this;
	}
	
	public VoorstellingBuilder setTitel(String titel) {
		this.titel = checkString(titel);
		return this;
	}
	
	public VoorstellingBuilder setUitvoerders(String uitvoerders) {
		this.uitvoerders = checkString(uitvoerders);
		return this;
	}
	
	public VoorstellingBuilder setDatum(LocalDateTime datum) {
		this.datum = checkLocalDateTime(datum);
		return this;
	}
	
	public VoorstellingBuilder setGenre(Genre genre) {
		this.genre = checkGenre(genre);
		return this;
	}
	
	public VoorstellingBuilder setPrijs(BigDecimal prijs) {
		this.prijs = checkBigDecimal(prijs);
		return this;
	}
	
	public VoorstellingBuilder setVrijePlaatsen(long vrijePlaatsen) {
		this.vrijePlaatsen = checkLong(vrijePlaatsen);
		return this;
	}
	
	@Override
	public Voorstelling build() {
		return new Voorstelling(id, titel, uitvoerders, datum, genre, prijs, vrijePlaatsen);
	}
}
