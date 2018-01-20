package be.vdab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.RepositoryException;

@WebServlet(urlPatterns = "/voorstellingen.htm", name = "voorstellingenservlet")
public class VoorstellingenServlet extends AbstractServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/voorstellingen.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAllGenresIn(request);
		try {
			setGenreEnVoorstellingenIn(request);
		} catch (NumberFormatException | RepositoryException ex) {
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
}
