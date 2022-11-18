package itea.web.view;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

public class Validation {
	public static final String REG_EMAIL = "^((([0-9A-Za-z]{1}[-0-9A-z\\.]{1,}[0-9A-Za-z]{1})|([0-9А-Яа-я]{1}[-0-9А-я\\.]{1,}[0-9А-Яа-я]{1}))@([-A-Za-z]{1,}\\.){1,2}[-A-Za-z]{2,})$";
	public static final String REG_PASSWORD = "^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$";
	
	
	public static StringBuilder checkErrors(HttpServletRequest request) {
		StringBuilder errors = null;
		if(request.getParameter("send") != null) {
			errors = new StringBuilder();	
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
		}
		return errors;
	}
	
	private static boolean isNoValidText(String text, String reg) {
		boolean check = false;
		if (Objects.isNull(text) || !text.matches(reg)) {
			check = true;
		}
		return check;
	}
	
	private static boolean isNoValidText(String text) {
		boolean check = false;
		if (Objects.isNull(text) || text.isEmpty()) {
			check = true;
		}
		return check;
	}
}
