package be.vdab.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import be.vdab.entities.OnvoldoendePlaatsException;
import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;

@WebServlet(urlPatterns = "/reserveren.htm", name = "reserverenservlet")
public class ReserverenServlet extends CultuurHuisServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/reserveren.jsp";
	// private static final String SUCCESS_REDIRECT = "/mandje.htm";
	private static final String FAILURE_REDIRECT = "/reserveren.htm";
	
	@Override
	void doGet(CultuurHuisGetRequest request) {
		request.setVoorstellingById(voorstellingRepository);
		Voorstelling voorstelling = request.getVoorstelling();
		for (Reservatie reservatie : request.getSession().getMandje()) {
			if (reservatie.getVoorstellingId() == voorstelling.getId()) {
				request.setPlaatsen(reservatie.getPlaatsen());
			}
		}
	}
	
	@Override
	void doPost(CultuurHuisPostRequest request) {
		CultuurHuisSession session = request.getSession();
		Voorstelling voorstelling = request.getVoorstellingById(voorstellingRepository);
		List<Reservatie> mandje = session.getMandje();
		long plaatsen = request.getPlaatsen();
		try {
			Reservatie reservatie = new Reservatie(voorstelling, plaatsen);
			List<Reservatie> nieuwMandje = new ArrayList<Reservatie>();
			for (Reservatie oudeReservatie : mandje) {
				if (oudeReservatie.getVoorstellingId() != reservatie.getVoorstellingId()) {
					nieuwMandje.add(oudeReservatie);
				}
			}
			session.setMandje(nieuwMandje);
			mandje = session.getMandje();
			mandje.add(reservatie);
			// request.setRedirect(SUCCESS_REDIRECT + "?voorstellingId=" + voorstelling.getId() + "&reminder=true");
		} catch (OnvoldoendePlaatsException ex) {
			request.setRedirect(FAILURE_REDIRECT + "?voorstellingId=" + voorstelling.getId() + "&reminder=true");
		}
	}
	
	@Override
	String getView() {
		return VIEW;
	}
}
