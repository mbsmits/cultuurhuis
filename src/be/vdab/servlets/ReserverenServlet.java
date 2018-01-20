package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Voorstelling;
import be.vdab.repositories.EntiteitRepository;
import be.vdab.repositories.VoorstellingRepository;

@WebServlet(urlPatterns = "/reserveren.htm", name = "reserverenservlet")
public class ReserverenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/reserveren.jsp";

	private final transient VoorstellingRepository voorstellingRepository = new VoorstellingRepository();

	@Resource(name = EntiteitRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		voorstellingRepository.setDataSource(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setVoorstellingIn(request);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	private void setVoorstellingIn(HttpServletRequest request) {
		long voorstellingsid = Long.parseLong(request.getParameter("voorstellingsid"));
		Voorstelling voorstelling = voorstellingRepository.findById(voorstellingsid);
		request.setAttribute("voorstelling", voorstelling);
	}

}
