package be.vdab.servlets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import be.vdab.entities.Genre;
import be.vdab.entities.Klant;
import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;

final class Request {

	private final HttpServletRequest delegate;

	public Request(HttpServletRequest delegate) {
		this.delegate = delegate;
	}

	Session getSession() {
		return new Session(delegate.getSession());
	}

	String getParameter(String name) {
		return delegate.getParameter(name);
	}

	void setAttribute(String name, Object value) {
		delegate.setAttribute(name, value);
	}

	long getKlantId() {
		return Long.parseLong(getParameter("klantId"));
	}

	long getPlaatsen(HttpServletRequest request) {
		return Long.parseLong(getParameter("plaatsen"));
	}

	void setGelukteReservatiesIn(List<Reservatie> gelukteReservaties) {
		setAttribute("gelukteReservaties", gelukteReservaties);
	}

	void setMislukteReservatiesIn(List<Reservatie> mislukteReservaties) {
		setAttribute("mislukteReservaties", mislukteReservaties);
	}

	void setPlaatsen(long plaatsen) {
		setAttribute("plaatsen", plaatsen);
	}

	void setGenre(Genre genre) {
		setAttribute("genre", genre);
	}

	void setGenres(List<Genre> genres) {
		setAttribute("genres", genres);
	}

	void setKlant(Klant klant) {
		setAttribute("klant", klant);
	}

	void setVoorstelling(Voorstelling voorstelling) {
		setAttribute("voorstelling", voorstelling);
	}

	void setFout(String fout) {
		setAttribute("fout", fout);
	}

	void setFouten(List<String> fouten) {
		setAttribute("fouten", fouten);
	}
}
