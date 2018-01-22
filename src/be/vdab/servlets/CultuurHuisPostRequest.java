package be.vdab.servlets;

import javax.servlet.http.HttpServletRequest;

final class CultuurHuisPostRequest extends CultuurHuisRequest {
	
	CultuurHuisPostRequest(HttpServletRequest delegate) {
		super(delegate);
	}
	
	void setRedirect(String redirect) {
		setAttribute("redirect", redirect);
	}
}
