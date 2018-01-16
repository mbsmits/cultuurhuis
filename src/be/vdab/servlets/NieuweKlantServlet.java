package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.KlantBuilder;
import be.vdab.repositories.KlantRepository;

@WebServlet(urlPatterns = "/nieuweklant.htm", name = "nieuweklantservlet")
public class NieuweKlantServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/nieuweklant.jsp";
	private static final String REDIRECT_URL = "/bevestigingreservaties.htm";
	
	private final transient KlantRepository klantRepository = KlantRepository.INSTANCE;
	
	@Resource(name = KlantRepository.JNDI_NAME)
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
		Map<String, String> fouten = new HashMap<>();
		// ...
		if (fouten.isEmpty()) {
			KlantBuilder builder = new KlantBuilder();
			builder.setVoornaam(request.getParameter("voornaam"));
			builder.setFamilienaam(request.getParameter("familienaam"));
			builder.setStraat(request.getParameter("straat"));
			builder.setHuisnr(request.getParameter("huisnr"));
			builder.setPostcode(request.getParameter("postcode"));
			builder.setGemeente(request.getParameter("gemeente"));
			builder.setGebruikersnaam(request.getParameter("gebruikersnaam"));
			builder.setPaswoord(request.getParameter("paswoord"));
			klantRepository.create(builder);
			response.sendRedirect(request.getContextPath() + REDIRECT_URL);
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}
	
}
