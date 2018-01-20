package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Reservatie;
import be.vdab.repositories.RepositoryException;

@WebServlet(urlPatterns = "/bevestig.htm", name = "bevestigservlet")
public class BevestigServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/bevestig.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/JSP/overzicht.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			setKlantIn(request);
		} catch (NullPointerException ex) {
			setFoutmeldingIn(request, ex.getMessage());
		} catch (RepositoryException ex) {
			setFoutmeldingIn(request, "Verkeerde gebruikersnaam of paswoord");
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long klantId = getKlantId(request);
		List<Reservatie> mandje = getMandje(request);
		List<Reservatie> gelukteReservaties = new ArrayList<>();
		List<Reservatie> mislukteReservaties = new ArrayList<>();
		for (Reservatie reservatie : mandje) {
			reservatie.setKlantId(klantId);
			try {
				maakReservatieAan(reservatie);
				gelukteReservaties.add(reservatie);
			} catch (Exception ex) {
				mislukteReservaties.add(reservatie);
			}
		}
		removeMandjeIn(request);
		setGelukteReservatiesIn(request, gelukteReservaties);
		setMislukteReservatiesIn(request, mislukteReservaties);
		request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
	}

}
