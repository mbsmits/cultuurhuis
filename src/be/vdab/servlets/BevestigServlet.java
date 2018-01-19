package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Klant;
import be.vdab.repositories.AbstractRepository;
import be.vdab.repositories.KlantRepository;
import be.vdab.repositories.ReservatieRepository;

@WebServlet(urlPatterns = "/bevestig.htm", name = "bevestigservlet")
public class BevestigServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/bevestig.jsp";

	private final transient KlantRepository klantRepository = new KlantRepository();
	private final transient ReservatieRepository reservatieRepository = new ReservatieRepository();

	@Resource(name = AbstractRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		klantRepository.setDataSource(dataSource);
		reservatieRepository.setDataSource(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			setKlantIn(request);
		} catch (NullPointerException ex) {
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	private void setKlantIn(HttpServletRequest request) {
		String gebruikersnaam = request.getParameter("gebruikersnaam");
		String paswoord = request.getParameter("paswoord");
		Klant klant = klantRepository.findByGebruikersnaamAndPaswoord(gebruikersnaam.trim(), paswoord.trim());
		request.setAttribute("klant", klant);
	}

}
