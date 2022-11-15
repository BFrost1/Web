package itea.web.view;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

public class Validation {
	private static final String REG_EMAIL = "^[a-zA-Z0-9]{1,}((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*@[a-zA-Z0-9]{1,}((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*\\.[a-zA-Z]{2,}$";
	private static final String REG_PASSWORD = "^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$";
	
	
	public StringBuilder checkErrors(HttpServletRequest request) {
		StringBuilder errors = new StringBuilder();	
		errors.append("</ul>");
		if(isNoValidText(request.getParameter("email"), REG_EMAIL)){
			errors.append("<li> not valid email</li>");
		}
		if(isNoValidText(request.getParameter("password"), REG_PASSWORD)){
			errors.append("<li>Password must contain at least 8 characters, 2 digits, 2 headers only in Latin</li>");
		}
		if(!Objects.equals(request.getParameter("password"), request.getParameter("rePassword"))){
			errors.append("<li>Password mismatch</li>");
		}
		if(isNoValidText(request.getParameter("fullName"))){
			errors.append("<li>Empty name</li>");
		}
		if(isNoValidText(request.getParameter("region"))){
			errors.append("<li>No region selected</li>");
		}
		if(isNoValidText(request.getParameter("gender"))){
			errors.append("<li>No gender selected</li>");
		}
		if(isNoValidText(request.getParameter("comment"))){
			errors.append("<li>Empty comments</li>");
		}
		if(isNoValidText(request.getParameter("agreement"))){
			errors.append("<li>No agreement</li>");
		}
		errors.append("</ul>");
		return errors;
	}
	
	private boolean isNoValidText(String text, String reg) {
		boolean check = false;
		if (Objects.isNull(text) || !text.matches(reg)) {
			check = true;
		}
		return check;
	}
	
	private boolean isNoValidText(String text) {
		boolean check = false;
		if (Objects.isNull(text) || text.isEmpty()) {
			check = true;
		}
		return check;
	}
}
