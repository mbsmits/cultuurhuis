package be.vdab.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Genre;
import be.vdab.entities.Voorstelling;
import be.vdab.repositories.AbstractRepository;
import be.vdab.repositories.GenreRepository;
import be.vdab.repositories.VoorstellingRepository;

@WebServlet(urlPatterns = "/voorstellingen.htm", name = "voorstellingenservlet")
public class VoorstellingenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/voorstellingen.jsp";

	private final transient GenreRepository genreRepository = new GenreRepository();
	private final transient VoorstellingRepository voorstellingRepository = new VoorstellingRepository();

	@Resource(name = AbstractRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		genreRepository.setDataSource(dataSource);
		voorstellingRepository.setDataSource(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			setGenreEnVoorstellingenIn(request);
		} catch (NumberFormatException ex) {
		}
		setGenresIn(request);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	private void setGenreEnVoorstellingenIn(HttpServletRequest request) {
		long genreid = Long.parseLong(request.getParameter("genreid"));
		Genre genre = genreRepository.findById(genreid);
		List<Voorstelling> voorstellingen = voorstellingRepository.findByGenre(genreid);
		request.setAttribute("genre", genre);
		request.setAttribute("voorstellingen", voorstellingen);
	}

	private void setGenresIn(HttpServletRequest request) {
		request.setAttribute("genres", genreRepository.findAll());
	}

}
