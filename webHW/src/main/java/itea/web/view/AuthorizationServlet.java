package itea.web.view;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itea.web.database.DBWorker;
import itea.web.database.UserManager;
import itea.web.entity.User;

public class AuthorizationServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		if(Objects.nonNull(req.getParameter("logout"))) {
			req.getSession().invalidate();
			req.getSession(true);
		}
		if(Objects.isNull(req.getSession().getAttribute("user"))) {
			resp.getWriter().write(GeneratorForm.getAuthorizationForm());
		}else {
			resp.getWriter().write(GeneratorForm.getLogout((User)req.getSession().getAttribute("user")));
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		if(Objects.nonNull(req.getParameter("login")) && Objects.nonNull(req.getParameter("password"))) {
			User user = new UserManager(new DBWorker()).getUser(req.getParameter("login"), req.getParameter("password"));
			if(Objects.nonNull(user)) {
				req.getSession().setAttribute("user", user);
				doGet(req, resp);
			}else {
				doGet(req, resp);
			}
		}
	}
	
	
}
