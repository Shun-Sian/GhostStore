package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import entities.User;
import repositories.UserRepository;
import services.UserService;
import services.impl.UserServiceImpl;
import utils.RequestIOUtils;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private UserService userService;
	
    public LoginServlet() {
        super();
        userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        User user = userService.login(username, password);
	        if (user == null) {
	            request.getSession().setAttribute("loginError", "Incorrect Username/Password");
	            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	        } else {
	            request.getSession().setAttribute("success", "Logged In Successfully");
	            request.getSession().setAttribute("loginError", null);
	            request.getSession().setAttribute("user", user);
	            request.getRequestDispatcher("index.jsp").forward(request, response);
	        }
	    }
	}