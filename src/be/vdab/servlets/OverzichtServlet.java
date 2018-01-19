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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import be.vdab.entities.Klant;
import be.vdab.entities.Reservatie;
import be.vdab.repositories.AbstractRepository;
import be.vdab.repositories.KlantRepository;
import be.vdab.repositories.ReservatieRepository;

@WebServlet(urlPatterns = "/overzicht.htm", name = "overzichtservlet")
public class OverzichtServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/overzicht.jsp";

	private final transient KlantRepository klantRepository = new KlantRepository();
	private final transient ReservatieRepository reservatieRepository = new ReservatieRepository();

	@Resource(name = AbstractRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		klantRepository.setDataSource(dataSource);
		reservatieRepository.setDataSource(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long klantid = Long.parseLong(request.getParameter("klantid"));
		Klant klant = klantRepository.findById(klantid);
		HttpSession session = request.getSession(false);
		@SuppressWarnings("unchecked")
		List<Reservatie> mandje = (List<Reservatie>) session.getAttribute("mandje");
		List<Reservatie> gelukteReservaties = new ArrayList<>();
		List<Reservatie> mislukteReservaties = new ArrayList<>();
		for (Reservatie reservatie : mandje) {
			reservatie.setKlant(klant);
			reservatieRepository.maakAan(reservatie);
			gelukteReservaties.add(reservatie);
		}
		session.setAttribute("mandje", null);
		request.setAttribute("geluktereservaties", gelukteReservaties);
		request.setAttribute("misluktereservaties", mislukteReservaties);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
