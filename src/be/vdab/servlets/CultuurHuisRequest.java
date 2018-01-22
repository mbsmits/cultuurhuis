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

final class CultuurHuisRequest {
	
	private final HttpServletRequest delegate;
	
	CultuurHuisRequest(HttpServletRequest delegate) {
		this.delegate = delegate;
	}
	
	Object getAttribute(String name) {
		return delegate.getAttribute(name);
	}
	
	private long getGenreId() {
		return Long.parseLong(getParameter("genreId"));
	}
	
	long getKlantId() {
		return Long.parseLong(getParameter("klantId"));
	}
	
	String getParameter(String name) {
		return delegate.getParameter(name);
	}
	
	long getPlaatsen() {
		return Long.parseLong(getParameter("plaatsen"));
	}
	
	CultuurHuisSession getSession() {
		return new CultuurHuisSession(delegate.getSession());
	}
	
	Voorstelling getVoorstelling() {
		return (Voorstelling) getAttribute("voorstelling");
	}
	
	private long getVoorstellingId() {
		return Long.parseLong(getParameter("voorstellingId"));
	}
	
	void setAllGenres(GenreRepository genreRepository) {
		setGenres(genreRepository.findAll());
	}
	
	void setAttribute(String name, Object value) {
		delegate.setAttribute(name, value);
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
	
	void setRedirect(String redirect) {
		setAttribute("redirect", redirect);
	}
	
	void setVoorstelling(Voorstelling voorstelling) {
		setAttribute("voorstelling", voorstelling);
	}
	
	void setVoorstellingById(VoorstellingRepository voorstellingRepository) {
		setVoorstelling(voorstellingRepository.findById(getVoorstellingId()));
	}
	
	void setTotaal(BigDecimal totaal) {
		setAttribute("totaal", totaal);
	}
	
	boolean getVerwijderingVoorstelling(long voorstellingId) {
		return getParameter("verwijderVoorstelling" + voorstellingId) != null;
	}
}
