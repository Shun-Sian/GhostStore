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
import models.Response;
import models.Token;
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
		request.getRequestDispatcher("static/login.html").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String isToken = request.getParameter("token");
			if(isToken != null) {
			Token authToken = RequestIOUtils.parseJSONtoObject(request, Token.class);
			User u = userService.login(authToken.getToken());
			RequestIOUtils.writeJSONResp(response, u);
			}else {
			User user = RequestIOUtils.parseJSONtoObject(request, User.class);
			String token = userService.login(user.getUsername(),user.getPassword());
			if(token == null) {
				Response responseBody = new Response("error","Incorrect Username/Password");
				RequestIOUtils.writeJSONResp(response, responseBody);
			}else {
				RequestIOUtils.writeJSONResp(response, new Response("token",token));
			}
		}
	}
}

