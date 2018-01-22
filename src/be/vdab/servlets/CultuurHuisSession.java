package be.vdab.servlets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;

final class CultuurHuisSession {
	
	private final HttpSession delegate;
	
	CultuurHuisSession(HttpSession delegate) {
		this.delegate = delegate;
	}
	
	List<Reservatie> getMandje() {
		if (delegate.getAttribute("mandje") == null) {
			delegate.setAttribute("mandje", new ArrayList<Reservatie>());
		}
		@SuppressWarnings("unchecked")
		List<Reservatie> mandje = (List<Reservatie>) delegate.getAttribute("mandje");
		return mandje;
	}
	
	BigDecimal getTotaal() {
		BigDecimal totaal = BigDecimal.ZERO;
		for (Reservatie reservatie : getMandje()) {
			Voorstelling voorstelling = reservatie.getVoorstelling();
			BigDecimal prijs = voorstelling.getPrijs();
			long plaatsen = reservatie.getPlaatsen();
			totaal = totaal.add(prijs.multiply(BigDecimal.valueOf(plaatsen)));
		}
		return totaal;
	}
	
	void setMandje(List<Reservatie> mandje) {
		delegate.setAttribute("mandje", mandje);
	}
	
	void removeMandje() {
		delegate.removeAttribute("mandje");
	}
}
