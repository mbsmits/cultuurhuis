package be.vdab.servlets;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Klant;
import be.vdab.entities.Reservatie;
import be.vdab.repositories.EntiteitRepository;
import be.vdab.repositories.GenreRepository;
import be.vdab.repositories.KlantRepository;
import be.vdab.repositories.ReservatieRepository;
import be.vdab.repositories.VoorstellingRepository;

abstract class CultuurHuisServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected final transient KlantRepository klantRepository = new KlantRepository();
	protected final transient GenreRepository genreRepository = new GenreRepository();
	protected final transient VoorstellingRepository voorstellingRepository = new VoorstellingRepository();
	protected final transient ReservatieRepository reservatieRepository = new ReservatieRepository();
	
	@Resource(name = EntiteitRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		klantRepository.setDataSource(dataSource);
		genreRepository.setDataSource(dataSource);
		voorstellingRepository.setDataSource(dataSource);
		reservatieRepository.setDataSource(dataSource);
	}
	
	abstract String getView();
	
	@Override
	protected final void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(new CultuurHuisGetRequest(request));
		request.getRequestDispatcher(getView()).forward(request, response);
	}
	
	@Override
	protected final void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(new CultuurHuisPostRequest(request));
		String redirect = (String) request.getAttribute("redirect");
		if (redirect != null) {
			response.sendRedirect(request.getContextPath() + redirect);
		}
	}
	
	abstract void doGet(CultuurHuisGetRequest request);
	
	void doPost(CultuurHuisPostRequest request) {
		// default implementation (do nothing)
	}
	
	void setKlantIn(HttpServletRequest request) {
		String gebruikersnaam = request.getParameter("gebruikersnaam");
		String paswoord = request.getParameter("paswoord");
		Klant klant = klantRepository.findByGebruikersnaamAndPaswoord(gebruikersnaam.trim(), paswoord.trim());
		request.setAttribute("klant", klant);
	}
	
	void maakKlantAanEnSetIn(HttpServletRequest request) {
		String voornaam = request.getParameter("voornaam");
		String familienaam = request.getParameter("familienaam");
		String straat = request.getParameter("straat");
		String huisnr = request.getParameter("huisnr");
		String postcode = request.getParameter("postcode");
		String gemeente = request.getParameter("gemeente");
		String gebruikersnaam = request.getParameter("gebruikersnaam");
		String paswoord = request.getParameter("paswoord");
		String paswoord2 = request.getParameter("paswoord2");
		if (!Objects.equals(paswoord, paswoord2)) {
			throw new IllegalArgumentException();
		}
		Klant klant = new Klant(voornaam, familienaam, straat, huisnr, postcode, gemeente, gebruikersnaam, paswoord);
		klantRepository.maakAan(klant);
		setKlantIn(request);
	}
	
	void maakReservatieAan(Reservatie reservatie) {
		reservatieRepository.maakAan(reservatie);
	}
}
