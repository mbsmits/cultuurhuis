package be.vdab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Genre;
import be.vdab.entities.Klant;
import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;
import be.vdab.repositories.EntiteitRepository;
import be.vdab.repositories.GenreRepository;
import be.vdab.repositories.KlantRepository;
import be.vdab.repositories.ReservatieRepository;
import be.vdab.repositories.VoorstellingRepository;

abstract class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final transient KlantRepository klantRepository = new KlantRepository();
	private final transient GenreRepository genreRepository = new GenreRepository();
	private final transient VoorstellingRepository voorstellingRepository = new VoorstellingRepository();
	private final transient ReservatieRepository reservatieRepository = new ReservatieRepository();

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
		doGet(new Request(request));
		request.getRequestDispatcher(getView()).forward(request, response);
	}

	@Override
	protected final void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(new Request(request));
		String redirect = getRedirect();
		if (redirect != null) {
			// redirect stuff
		}
	}

	abstract void doGet(Request request);

	void doPost(Request request) {
	}

	String getRedirect() {
		return null;
	}

	private List<Reservatie> getMandje(HttpServletRequest request) {
		return new Request(request).getSession().getMandje();
	}

	void setAllGenresIn(HttpServletRequest request) {
		request.setAttribute("genres", genreRepository.findAll());
	}

	void setGenreEnVoorstellingenIn(HttpServletRequest request) {
		long genreId = Long.parseLong(request.getParameter("genreId"));
		Genre genre = genreRepository.findById(genreId);
		List<Voorstelling> voorstellingen = voorstellingRepository.findByGenre(genreId);
		request.setAttribute("genre", genre);
		request.setAttribute("voorstellingen", voorstellingen);
	}

	Voorstelling getVoorstelling(HttpServletRequest request) {
		long voorstellingId = Long.parseLong(request.getParameter("voorstellingId"));
		Voorstelling voorstelling = voorstellingRepository.findById(voorstellingId);
		return voorstelling;
	}

	void setTotaalIn(HttpServletRequest request) {
		BigDecimal totaal = BigDecimal.ZERO;
		for (Reservatie reservatie : getMandje(request)) {
			Voorstelling voorstelling = reservatie.getVoorstelling();
			BigDecimal prijs = voorstelling.getPrijs();
			long plaatsen = reservatie.getPlaatsen();
			totaal = totaal.add(prijs.multiply(BigDecimal.valueOf(plaatsen)));
		}
		request.setAttribute("totaal", totaal);
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
