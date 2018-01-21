package be.vdab.servlets;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/voorstellingen.htm", name = "voorstellingenservlet")
public class VoorstellingenServlet extends Servlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/voorstellingen.jsp";

	@Override
	void doGet(Request request) {
		// setAllGenresIn(request);
		// try {
		// setGenreEnVoorstellingenIn(request);
		// } catch (NumberFormatException | RepositoryException ex) {
		// }

	}

	@Override
	String getView() {
		return VIEW;
	}

}
