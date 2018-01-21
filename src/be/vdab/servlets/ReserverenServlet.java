package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;

@WebServlet(urlPatterns = "/reserveren.htm", name = "reserverenservlet")
public class ReserverenServlet extends Servlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/reserveren.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/JSP/mandje.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Voorstelling voorstelling = getVoorstelling(request);
		setVoorstellingIn(request, voorstelling);
		for (Reservatie reservatie: getMandje(request)) {
			if (reservatie.getVoorstellingId() == voorstelling.getId()) {
				setPlaatsenIn(request,reservatie.getPlaatsen());
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Voorstelling voorstelling = getVoorstelling(request);
		setVoorstellingIn(request, voorstelling);
		List<Reservatie> mandje = getMandje(request);
		long plaatsen = getPlaatsen(request);
		try {
			Reservatie reservatie = new Reservatie(voorstelling, plaatsen);
			List<Reservatie> nieuwMandje = new ArrayList<Reservatie>(); // TODO
			for (Reservatie oudeReservatie: mandje) {
				if (oudeReservatie.getVoorstellingId() != reservatie.getVoorstellingId()) {
					nieuwMandje.add(oudeReservatie);
				}
			}
			setMandjeIn(request, nieuwMandje);
			mandje = getMandje(request);
			mandje.add(reservatie);
			request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
		} catch (IllegalArgumentException ex) {
			setFoutmeldingIn(request,ex.getMessage());	// wordt nog niet gebruikt
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

}
