package be.vdab.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;

@WebServlet(urlPatterns = "/reserveren.htm", name = "reserverenservlet")
public class ReserverenServlet extends CultuurHuisServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/reserveren.jsp";
	private static final String REDIRECT = "/mandje.htm";
	
	@Override
	void doGet(CultuurHuisRequest request) {
		request.setVoorstellingById(voorstellingRepository);
		Voorstelling voorstelling = request.getVoorstelling();
		for (Reservatie reservatie : request.getSession().getMandje()) {
			if (reservatie.getVoorstellingId() == voorstelling.getId()) {
				request.setPlaatsen(reservatie.getPlaatsen());
			}
		}
	}
	
	@Override
	void doPost(CultuurHuisRequest request) {
		CultuurHuisSession session = request.getSession();
		request.setVoorstellingById(voorstellingRepository);
		Voorstelling voorstelling = request.getVoorstelling();
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
		} catch (IllegalArgumentException ex) {
			request.setFout(ex.getMessage());
			request.setRedirect(REDIRECT);
		}
	}
	
	@Override
	String getView() {
		return VIEW;
	}
}
