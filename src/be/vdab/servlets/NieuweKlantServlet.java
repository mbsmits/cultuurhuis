package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Klant;
import be.vdab.repositories.EntiteitRepository;
import be.vdab.repositories.KlantRepository;

@WebServlet(urlPatterns = "/nieuweklant.htm", name = "nieuweklantservlet")
public class NieuweKlantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/nieuweklant.jsp";
	private static final String REDIRECT_URL = "/bevestig.htm";

	private final transient KlantRepository klantRepository = new KlantRepository();

	@Resource(name = EntiteitRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		klantRepository.setDataSource(dataSource);
	}

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
			response.sendRedirect(request.getContextPath() + REDIRECT_URL);
		} catch (NullPointerException ex) {
			setFoutenIn(request, ex);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

	private void maakKlantAanEnSetIn(HttpServletRequest request) {
		String voornaam = request.getParameter("voornaam");
		String familienaam = request.getParameter("familienaam");
		String straat = request.getParameter("straat");
		String huisnr = request.getParameter("huisnr");
		String postcode = request.getParameter("postcode");
		String gemeente = request.getParameter("gemeente");
		String gebruikersnaam = request.getParameter("gebruikersnaam");
		String paswoord = request.getParameter("paswoord");
		Klant klant = new Klant(voornaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord);
		klantRepository.maakAan(klant);
	}

	private void setFoutenIn(HttpServletRequest request, Exception ex) {
		List<String> fouten = new ArrayList<>();
		fouten.add(ex.getMessage());
		request.setAttribute("fouten", fouten);
	}

}
