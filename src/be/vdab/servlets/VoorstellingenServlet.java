package be.vdab.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Genre;
import be.vdab.repositories.GenreRepository;
import be.vdab.repositories.VoorstellingRepository;
import be.vdab.util.StringUtils;

@WebServlet(urlPatterns = "/voorstellingen.htm", name = "voorstellingenservlet")
public class VoorstellingenServlet extends HttpServlet {
	
	private static final long	serialVersionUID	= 1L;
	private static final String	VIEW				= "/WEB-INF/JSP/voorstellingen.jsp";
	
	private final transient GenreRepository			genreRepository			= GenreRepository.INSTANCE;
	private final transient VoorstellingRepository	voorstellingRepository	= VoorstellingRepository.INSTANCE;
	
	@Resource(name = GenreRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		genreRepository.setDataSource(dataSource);
		voorstellingRepository.setDataSource(dataSource); // TODO: dirty
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("genres", genreRepository.findAll());
		String genreid = request.getParameter("genreid");
		if (genreid != null) {
			if (StringUtils.isLong(genreid)) {
				Optional<Genre> optional = genreRepository.read(Long.parseLong(genreid));
				optional.ifPresent(genre -> request.setAttribute("genre", genre));
				optional.ifPresent(
						genre -> request.setAttribute("voorstellingen", voorstellingRepository.findByGenre(genre)));
			} else {
				request.setAttribute("fout", "genreid niet correct");
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
}
