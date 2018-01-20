package be.vdab.servlets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

abstract class AbstractServlet extends HttpServlet {

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

	List<Reservatie> getMandje(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("mandje") == null) {
			session.setAttribute("mandje", new ArrayList<Reservatie>());
		}
		@SuppressWarnings("unchecked")
		List<Reservatie> mandje = (List<Reservatie>) session.getAttribute("mandje");
		return mandje;
	}

	void setMandjeIn(HttpServletRequest request, List<Reservatie> mandje) {
		HttpSession session = request.getSession();
		session.setAttribute("mandje", mandje);
	}

	void removeMandjeIn(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("mandje");
	}
	
	Voorstelling getVoorstelling(HttpServletRequest request) {
		long voorstellingId = Long.parseLong(request.getParameter("voorstellingId"));
		Voorstelling voorstelling = voorstellingRepository.findById(voorstellingId);
		return voorstelling;
	}

	void setVoorstellingIn(HttpServletRequest request, Voorstelling voorstelling) {
		request.setAttribute("voorstelling", voorstelling);
	}

	void setVoorstellingIn(HttpServletRequest request) {
		Voorstelling voorstelling = getVoorstelling(request);
		request.setAttribute("voorstelling", voorstelling);
	}

	long getPlaatsen(HttpServletRequest request) {
		long plaatsen = Long.parseLong(request.getParameter("plaatsen"));
		return plaatsen;
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

	void setPlaatsenIn(HttpServletRequest request, long plaatsen) {
		request.setAttribute("plaatsen", plaatsen);
	}

	void setFoutmeldingIn(HttpServletRequest request, String foutmelding) {
		request.setAttribute("foutmelding", foutmelding);
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

	void setFoutenIn(HttpServletRequest request, String message) {
		List<String> fouten = new ArrayList<>();
		fouten.add(message);
		request.setAttribute("fouten", fouten);
	}
	
	long getKlantId(HttpServletRequest request) {
		long klantId = Long.parseLong(request.getParameter("klantId"));
		return klantId;
	}
	
	void maakReservatieAan(Reservatie reservatie) {
		reservatieRepository.maakAan(reservatie);
	}
	
	void setGelukteReservatiesIn(HttpServletRequest request, List<Reservatie> gelukteReservaties) {
		request.setAttribute("gelukteReservaties", gelukteReservaties);
	}
	
	void setMislukteReservatiesIn(HttpServletRequest request, List<Reservatie> mislukteReservaties) {
		request.setAttribute("mislukteReservaties", mislukteReservaties);
	}
	
}
