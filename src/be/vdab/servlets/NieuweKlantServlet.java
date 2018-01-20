package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.RepositoryException;

@WebServlet(urlPatterns = "/nieuweklant.htm", name = "nieuweklantservlet")
public class NieuweKlantServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/nieuweklant.jsp";
	private static final String SUCCESS_VIEW = "/WEB-INF/JSP/bevestig.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			maakKlantAanEnSetIn(request);
			request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
		} catch (NullPointerException ex) {
			setFoutenIn(request, "Velden werden leegelaten.");
			request.getRequestDispatcher(VIEW).forward(request, response);
		} catch (IllegalArgumentException ex) {
			setFoutenIn(request, "Paswoord en Herhaal paswoord zijn verschillend.");
			request.getRequestDispatcher(VIEW).forward(request, response);
		} catch (RepositoryException ex) {
			setFoutenIn(request, "Een klant met Gebruikersnaam komt al voor in de database.");
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

}
