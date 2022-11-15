package itea.web.view;


public class Form {
	public static final String AUTHORIZATION_FORM = 
			"<html>"
			+ "<center>\r\n"
			+ "	<form action=\"/authorization\" method = 'POST'>\r\n"
			+ "		<table border=\"0\">\r\n"
			+ "			<tr>\r\n"
			+ "				<td width=\"100\">Login</td>\r\n"
			+ "				<td ><input type=\"email\" name=\"login\" required /></td>\r\n"
			+ "			</tr>\r\n"
			+ "			<tr>\r\n"
			+ "				<td>Password</td>\r\n"
			+ "				<td><input type=\"password\" name=\"password\" required /></td>\r\n"
			+ "			</tr>\r\n"
			+ "			<tr>\r\n"
			+ "				<td align=\"center\" colspan=\"2\"><input type=\"submit\" value=\"Send\" /></td>\r\n"
			+ "			</tr>\r\n"
			+ "		</table>\r\n"
			+ "	</form>\r\n"
			+ "</center>"
			+ "<html/>";
}
	
