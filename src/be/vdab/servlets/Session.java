package be.vdab.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import be.vdab.entities.Reservatie;

final class Session {

	private final HttpSession delegate;

	Session(HttpSession delegate) {
		this.delegate = delegate;
	}

	List<Reservatie> getMandje() {
		if (delegate.getAttribute("mandje") == null) {
			delegate.setAttribute("mandje", new ArrayList<Reservatie>());
		}
		@SuppressWarnings("unchecked")
		List<Reservatie> mandje = (List<Reservatie>) delegate.getAttribute("mandje");
		return mandje;
	}

	void setMandje(List<Reservatie> mandje) {
		delegate.setAttribute("mandje", mandje);
	}

	void removeMandje() {
		delegate.removeAttribute("mandje");
	}

}
