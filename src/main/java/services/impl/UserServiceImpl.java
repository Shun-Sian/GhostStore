package services.impl;


import java.util.Objects;


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
	public User login(String username, String password) {
		User user = userRep.getUser(username);
		if(user != null && !password.equals(user.getPassword())) {
			return null;
		}
		if(user ==null) {
			return null;
		}
		LoggedUsers.addUser(user);
		return user;
	}

	@Override
	public void logout(String username) {
		User user = userRep.getUser(username);
		LoggedUsers.removeUser(user);
		
	}

}
