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

import be.vdab.entities.Reservatie;
import be.vdab.repositories.EntiteitRepository;
import be.vdab.repositories.KlantRepository;
import be.vdab.repositories.ReservatieRepository;

@WebServlet(urlPatterns = "/overzicht.htm", name = "overzichtservlet")
public class OverzichtServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/overzicht.jsp";

	private final transient KlantRepository klantRepository = new KlantRepository();
	private final transient ReservatieRepository reservatieRepository = new ReservatieRepository();

	@Resource(name = EntiteitRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		klantRepository.setDataSource(dataSource);
		reservatieRepository.setDataSource(dataSource);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long klantId = Long.parseLong(request.getParameter("klantId"));
		HttpSession session = request.getSession(false);
		Mandje mandje = (Mandje) session.getAttribute("mandje");
		mandje.setKlantId(klantId);
		List<Reservatie> gelukteReservaties = new ArrayList<>();
		List<Reservatie> mislukteReservaties = new ArrayList<>();
		for (Reservatie reservatie : mandje) {
			try {
				reservatieRepository.maakAan(reservatie);
				gelukteReservaties.add(reservatie);
			} catch (Exception ex) {
				mislukteReservaties.add(reservatie);
			}
		}
		session.removeAttribute("mandje");
		request.setAttribute("geluktereservaties", gelukteReservaties);
		request.setAttribute("misluktereservaties", mislukteReservaties);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
