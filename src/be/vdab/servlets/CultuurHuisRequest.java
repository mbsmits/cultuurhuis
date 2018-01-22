package be.vdab.servlets;

import javax.servlet.http.HttpServletRequest;

import be.vdab.entities.Voorstelling;
import be.vdab.repositories.VoorstellingRepository;

abstract class CultuurHuisRequest {
	
	private final HttpServletRequest delegate;
	
	CultuurHuisRequest(HttpServletRequest delegate) {
		this.delegate = delegate;
	}
	
	Object getAttribute(String name) {
		return delegate.getAttribute(name);
	}
	
	long getGenreId() {
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
	
	boolean getVerwijderingVoorstelling(long voorstellingId) {
		return getParameter("verwijderVoorstelling" + voorstellingId) != null;
	}
	
	Voorstelling getVoorstelling() {
		return (Voorstelling) getAttribute("voorstelling");
	}
	
	Voorstelling getVoorstellingById(VoorstellingRepository voorstellingRepository) {
		return voorstellingRepository.findById(getVoorstellingId());
	}
	
	long getVoorstellingId() {
		return Long.parseLong(getParameter("voorstellingId"));
	}
	
	void setAttribute(String name, Object value) {
		delegate.setAttribute(name, value);
	}
}
