package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import be.vdab.entities.Reservatie;
import be.vdab.entities.Voorstelling;
import be.vdab.repositories.EntiteitRepository;
import be.vdab.repositories.VoorstellingRepository;

@WebServlet(urlPatterns = "/mandje.htm", name = "mandjeservlet")
public class MandjeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/mandje.jsp";

	private final transient VoorstellingRepository voorstellingRepository = new VoorstellingRepository();

	@Resource(name = EntiteitRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		voorstellingRepository.setDataSource(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			voegReservatieAanMandjeToe(request);
		} catch (NumberFormatException ex) {
		}
		verwijderVoorstellingUitMandje(request);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	private void voegReservatieAanMandjeToe(HttpServletRequest request) {
		long voorstellingId = Long.parseLong(request.getParameter("voorstellingid"));
		Voorstelling voorstelling = voorstellingRepository.findById(voorstellingId);
		long plaatsen = Long.parseLong(request.getParameter("plaatsen"));
		Reservatie reservatie = new Reservatie(voorstelling, plaatsen);
		HttpSession session = request.getSession();
		if (session.getAttribute("mandje") == null) {
			session.setAttribute("mandje", new Mandje());
		}
		Mandje mandje = (Mandje) session.getAttribute("mandje");
		mandje.addOrReplace(reservatie);
	}

	private void verwijderVoorstellingUitMandje(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Mandje mandje = (Mandje) session.getAttribute("mandje");
		Mandje nieuwMandje = new Mandje();
		for (Reservatie reservatie : mandje) {
			boolean on = (request.getParameter("verwijderVoorstelling" + reservatie.getVoorstellingId()) != null);
			if (!on) {
				nieuwMandje.addOrReplace(reservatie);
			}
		}
		session.setAttribute("mandje", nieuwMandje);
	}

}
