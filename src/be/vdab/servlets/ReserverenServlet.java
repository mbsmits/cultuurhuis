package be.vdab.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;

@WebServlet(urlPatterns = "/reserveren.htm", name = "reserverenservlet")
public class ReserverenServlet extends Servlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/reserveren.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/JSP/mandje.jsp";

	@Override
	void doGet(Request request) {
		request.setVoorstellingById(voorstellingRepository);
		Voorstelling voorstelling = request.getVoorstelling();
		for (Reservatie reservatie : request.getSession().getMandje()) {
			if (reservatie.getVoorstellingId() == voorstelling.getId()) {
				request.setPlaatsen(reservatie.getPlaatsen());
			}
		}
	}

	@Override
	void doPost(Request request) {
		request.setVoorstellingById(voorstellingRepository);
		Voorstelling voorstelling = request.getVoorstelling();
		List<Reservatie> mandje = getMandje(request);
		long plaatsen = getPlaatsen(request);
		try {
			Reservatie reservatie = new Reservatie(voorstelling, plaatsen);
			List<Reservatie> nieuwMandje = new ArrayList<Reservatie>(); // TODO
			for (Reservatie oudeReservatie : mandje) {
				if (oudeReservatie.getVoorstellingId() != reservatie.getVoorstellingId()) {
					nieuwMandje.add(oudeReservatie);
				}
			}
			request.setMandje(nieuwMandje);
			mandje = request.getMandje();
			mandje.add(reservatie);
			request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
		} catch (IllegalArgumentException ex) {
			request.setFout(ex.getMessage()); // wordt nog niet gebruikt
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

	@Override
	String getView() {
		return VIEW;
	}

}
