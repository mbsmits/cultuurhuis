package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.vdab.entities.Reservatie;

@WebServlet(urlPatterns = "/mandje.htm", name = "mandjeservlet")
public class MandjeServlet extends Servlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/mandje.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setTotaalIn(request);
		request.getRequestDispatcher(VIEW).forward(request, response);	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Reservatie> nieuwMandje = new ArrayList<Reservatie>(); // TODO
			for (Reservatie reservatie: getMandje(request)) {
				boolean on = (request.getParameter("verwijderVoorstelling" + reservatie.getVoorstellingId()) != null);
				if (!on) {
					nieuwMandje.add(reservatie);
				}
			}
			setMandjeIn(request, nieuwMandje);
		} catch (NullPointerException ex) {
		}
		setTotaalIn(request);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
