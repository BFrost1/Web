package itea.web.view;

import java.util.Objects;

import itea.web.entity.User;

public class GeneratorForm {
	
	public static String getAuthorizationForm() {
		StringBuilder sb = new StringBuilder();
		sb.append(getHeaderForm());
		sb.append("<center>")
		.append("<form action='' method = 'POST'>")
		.append("<table border='0'>")
		.append("<tr>")
		.append("<td width='100'>Login</td>")
		.append("<td><input type='email' name='login' required /></td>")
		.append("</tr>")
		.append("<tr>")
		.append("<td width='100'>Password</td>")
		.append("<td><input type='password' name='password' required /></td>")
		.append("</tr>")
		.append("<tr>")
		.append("<td align='center' colspan='2'><input type='submit' value='Send' /></td>")
		.append("</tr>")
		.append("</table>")
		.append("</form>")
		.append("</center>")
		.append(getFooterForm());
		return sb.toString();
	}
	
	public static String getRegistrationForm(StringBuilder errors) {
		StringBuilder sb = new StringBuilder();
		sb.append(getHeaderForm())
		.append("<div class='registrationBox'>")
		.append("<h2>Registration</h2>")
		.append("<form action='' method='post'>")
		.append("<label class='icon'><i class='far fa-envelope'></i></label>")
		.append("<input type='text' name = 'email' placeholder='Email' pattern='").append(Validation.REG_EMAIL).append("' required/>")
		.append("<label class='icon'><i class='fas fa-shield-alt'></i></label>")
		.append("<input type='password' name='password' placeholder='Password' pattern='").append(Validation.REG_PASSWORD).append("' required />")
		.append("<label class='icon'><i class='fas fa-shield-alt'></i></label>")
		.append("<input type='password' name='rePassword' placeholder='Re-password' pattern='").append(Validation.REG_PASSWORD).append("' required />")
		.append("<label class='icon'><i class='fas fa-user'></i></label>")
		.append("<input type='text' name='fullName' placeholder='Full name' required/>")
		.append("<label class='icon'><i class='fas fa-map-marker-alt'></i></label>")
		.append("<select name = 'region'>")
		.append("<option value = 'Lviv'> Lviv region</option>")
		.append("<option value = 'Kyiv'> Kyiv region</option>")
		.append("<option value = 'Kharkiv'>Kharkiv region</option>")
		.append("</select>")
		.append("<label class='icon'><i class='fas fa-venus-mars'></i></label>")
		.append("<select name = 'gender'>")
		.append("<option value = 'male'>Male</option>")
		.append("<option value = 'female'>Female</option>")
		.append("</select>")
		.append("<div class ='comment'>")
		.append("<label class='icon'><i class='far fa-comment'></i></label>")
		.append("<textarea  name = 'comment' ></textarea>")
		.append("</div>")
		.append("<div class='checkbox'>")
		.append("<p>I agree to the processing of my personal data</p>")
		.append("<input type='checkbox' name='agreement'/>")
		.append("</div>")
		.append("<input type='submit' value='send' name='send'/>")
		.append("</form>")
		.append("</div>")
		.append(Objects.isNull(errors)? "":errors)
		.append(getFooterForm());
		return sb.toString();
	}
	
	public static StringBuilder getHeaderForm() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>")
		.append("<head>")
		.append("<title>Photoshoot by FCT</title>")
		.append("<script src='https://kit.fontawesome.com/752f20c697.js' crossorigin='anonymous'></script>")
		.append("</head>")
		.append("<body>")
		.append("<a href='/authorization'>Sing in</a>")
		.append("<br>")
		.append("<a href='/registration'>Registration</a>");
		return sb;
	}
	
	public static StringBuilder getFooterForm() {
		StringBuilder sb = new StringBuilder();
		sb.append("</body>")
		.append("</html>");
		return sb;
	}
	
	
	public static String getHeaderFooter(String text) {
		return new StringBuilder().append(getHeaderForm()).append(text).append(getFooterForm()).toString();
	}
	
	public static String getLogout(User user) {
		return new StringBuilder().append("Hello, ").append(user.getName()).append("<a href='/authorization?logout'>Log out</a>").append(getFooterForm()).toString();
	}
	
}
	
