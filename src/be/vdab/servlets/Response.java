package be.vdab.servlets;

import javax.servlet.http.HttpServletResponse;

public final class Response {

	private final HttpServletResponse delegate;

	public Response(HttpServletResponse delegate) {
		this.delegate = delegate;
	}

}
