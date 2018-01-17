package be.vdab.servlets;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import be.vdab.entities.Reservatie;
import be.vdab.entities.ReservatieBuilder;
import be.vdab.repositories.GenreRepository;
import be.vdab.repositories.ReservatieRepository;

@WebServlet(urlPatterns = "/overzicht.htm", name = "overzichtservlet")
public class OverzichtServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/overzicht.jsp";
	private final transient ReservatieRepository reservatieRepository = ReservatieRepository.INSTANCE;
	
	@Resource(name = GenreRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		reservatieRepository.setDataSource(dataSource);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		@SuppressWarnings("unchecked")
		List<ReservatieBuilder> builders = (List<ReservatieBuilder>) session.getAttribute("reservatiesbuilders");
		builders.stream().forEach(builder -> reservatieRepository.create(builder));
		builders.clear();
		SortedSet<Reservatie> gelukteReservaties = new TreeSet<>(); // TODO
		SortedSet<Reservatie> mislukteReservaties = new TreeSet<>(); // TODO
		request.setAttribute("geluktereservaties", gelukteReservaties);
		request.setAttribute("misluktereservaties", mislukteReservaties);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
