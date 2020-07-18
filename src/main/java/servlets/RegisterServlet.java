package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.JDBCConnector;
import entities.User;
import repositories.UserRepository;
import services.UserService;
import services.impl.UserServiceImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private UserService userService;
	
    public RegisterServlet() {
    	super();
    	userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("static/registerPage.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		User u = userService.registerUser(pass, username);
		if(u == null) {
			response.getWriter().write("Register failed");
		}
		else {
			request.getRequestDispatcher("static/login.html").forward(request, response);;
		}
	}
}
