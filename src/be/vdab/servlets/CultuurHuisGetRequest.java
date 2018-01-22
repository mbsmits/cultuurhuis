package be.vdab.servlets;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import be.vdab.entities.Genre;
import be.vdab.entities.Klant;
import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;
import be.vdab.repositories.GenreRepository;
import be.vdab.repositories.VoorstellingRepository;

final class CultuurHuisGetRequest extends CultuurHuisRequest {
	
	CultuurHuisGetRequest(HttpServletRequest delegate) {
		super(delegate);
	}
	
	void setFout(String fout) {
		setAttribute("fout", fout);
	}
	
	void setFouten(List<String> fouten) {
		setAttribute("fouten", fouten);
	}
	
	void setGelukteReservatiesIn(List<Reservatie> gelukteReservaties) {
		setAttribute("gelukteReservaties", gelukteReservaties);
	}
	
	void setGenre(Genre genre) {
		setAttribute("genre", genre);
	}
	
	void setGenreById(GenreRepository genreRepository) {
		setGenre(genreRepository.findById(getGenreId()));
	}
	
	void setGenres(GenreRepository genreRepository) {
		setGenres(genreRepository.findAll());
	}
	
	void setGenres(List<Genre> genres) {
		setAttribute("genres", genres);
	}
	
	void setKlant(Klant klant) {
		setAttribute("klant", klant);
	}
	
	void setMislukteReservatiesIn(List<Reservatie> mislukteReservaties) {
		setAttribute("mislukteReservaties", mislukteReservaties);
	}
	
	void setPlaatsen(long plaatsen) {
		setAttribute("plaatsen", plaatsen);
	}
	
	void setTotaal(BigDecimal totaal) {
		setAttribute("totaal", totaal);
	}
	
	void setVoorstelling(Voorstelling voorstelling) {
		setAttribute("voorstelling", voorstelling);
	}
	
	void setVoorstellingById(VoorstellingRepository voorstellingRepository) {
		setVoorstelling(voorstellingRepository.findById(getVoorstellingId()));
	}
	
	private void setVoorstellingen(List<Voorstelling> voorstellingen) {
		setAttribute("voorstellingen", voorstellingen);
	}
	
	void setVoorstellingenByGenreId(VoorstellingRepository voorstellingRepository) {
		setVoorstellingen(voorstellingRepository.findByGenreId(getGenreId()));
	}
}
