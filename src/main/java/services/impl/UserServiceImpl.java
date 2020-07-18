package services.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import auth.LoggedUsers;
import entities.User;
import repositories.UserRepository;
import services.UserService;

public class UserServiceImpl implements UserService{

	private UserRepository userRep;
	
	public UserServiceImpl() {
		userRep = new UserRepository();
	}
	
	@Override
	public User registerUser(String password, String username) {
		if(userRep.getUser(username) != null) {
			return null;
		}
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		
		return userRep.addUser(user);
	
	}

	@Override
	public String login(String username, String password) {
		User user = userRep.getUser(username);
		if(user == null) {
			//no such user,login failed
			return null;
		}
		if(user.getPassword().equals(password)) {
			//password matches,login success 
			LoggedUsers.addUser(user);
			String token = generateToken(username);
			return token;
		}
		
		return null;
	}

	@Override
	public User login(String authToken) {
		String username = authToken.split("\\|")[1];
		if(LoggedUsers.getUser(username) != null) {
			return LoggedUsers.getUser(username);
		}
		return null;
	}

	private String generateToken(String username) {
		long currentTimeInMs = Calendar.getInstance().getTimeInMillis();
		return String.format("%s|%s|%d", UUID.randomUUID().toString(), username, currentTimeInMs);		
	}

}
