package itea.web.view;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itea.web.database.DBWorker;
import itea.web.database.UserManager;
import itea.web.entity.User;

public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		if(Objects.isNull(req.getSession().getAttribute("user"))) {
			resp.getWriter().write(GeneratorForm.getRegistrationForm(Validation.checkErrors(req)));
		}else {
			resp.getWriter().write(GeneratorForm.getLogout((User)req.getSession().getAttribute("user")));
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		if(Validation.checkErrors(req).indexOf("li") == -1) {
			resp.getWriter().write(Validation.checkErrors(req).toString());
			new UserManager(new DBWorker()).addUser(new User(req.getParameter("email"), req.getParameter("password"),
					req.getParameter("fullName"), req.getParameter("region"), req.getParameter("gender"),
					req.getParameter("comment"), Boolean.valueOf(req.getParameter("agreement"))));
			resp.getWriter().write(GeneratorForm.getHeaderFooter("You are registered").toString());
		}else {
			doGet(req, resp);
		}
	}
	public static void main(String[] args) {
		System.out.println(Objects.isNull(new Object()));
	}
}
