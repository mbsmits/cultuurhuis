package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.repositories.VoorstellingRepository;
import be.vdab.util.StringUtils;

@WebServlet("/genre.htm")
public class GenreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/genre.jsp";

	private final transient VoorstellingRepository voorstellingRepository = new VoorstellingRepository();

	@Resource(name = VoorstellingRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		voorstellingRepository.setDataSource(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (StringUtils.isLong(id)) {
			voorstellingRepository.read(Long.parseLong(id), null) // TODO: null weg
					.ifPresent(voorstelling -> request.setAttribute("voorstelling", voorstelling));
		} else {
			request.setAttribute("fout", "id niet correct");
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
