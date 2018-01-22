package be.vdab.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import be.vdab.entities.Reservatie;

@WebServlet(urlPatterns = "/mandje.htm", name = "mandjeservlet")
public class XMandjeServlet extends CultuurHuisServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/mandje.jsp";
	
	@Override
	String getView() {
		return VIEW;
	}
	
	@Override
	void doGet(CultuurHuisGetRequest request) {
		request.setTotaal(request.getSession().getTotaal());
	}
	
	@Override
	void doPost(CultuurHuisPostRequest request) {
		CultuurHuisSession session = request.getSession();
		try {
			List<Reservatie> nieuwMandje = new ArrayList<Reservatie>(); // TODO
			for (Reservatie reservatie : session.getMandje()) {
				if (!request.getVerwijderingVoorstelling(reservatie.getVoorstellingId())) {
					nieuwMandje.add(reservatie);
				}
			}
			session.setMandje(nieuwMandje);
		} catch (NullPointerException ex) {
		}
	}
}
