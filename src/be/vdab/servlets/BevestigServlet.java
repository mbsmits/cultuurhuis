package be.vdab.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import be.vdab.repositories.AbstractRepository;
import be.vdab.repositories.ReservatieRepository;

@WebServlet(urlPatterns = "/bevestig.htm", name = "bevestigservlet")
public class BevestigServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/bevestig.jsp";

	private final transient ReservatieRepository reservatieRepository = new ReservatieRepository();

	@Resource(name = AbstractRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		reservatieRepository.setDataSource(dataSource);
	}

	//	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameterValues("id") != null) {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			Set<Long> mandje = (Set<Long>) session.getAttribute("mandje");
			if (mandje == null) {
				mandje = new LinkedHashSet<>();
			}
			mandje.addAll(Arrays.stream(request.getParameterValues("id")).map(id -> Long.parseLong(id))
					.collect(Collectors.toSet()));
			session.setAttribute("mandje", mandje);
		}
		response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
	}

}
