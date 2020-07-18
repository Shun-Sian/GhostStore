package auth;

import java.util.HashMap;
import java.util.Map;

import entities.User;

public class LoggedUsers {

	//list
	private static final Map<String, User> LOGGED_IN_USERS = new HashMap<>();
	
	private LoggedUsers() {
	}
	
	public static User getUser(String username) {
		return LOGGED_IN_USERS.get(username);
	}
	
	public static User getUser(User user) {
		return LOGGED_IN_USERS.get(user.getUsername());
	}
	
	public static void addUser(User user) {
		LOGGED_IN_USERS.put(user.getUsername(), user);
	}
	
	public static void removeUser(User user) {
		LOGGED_IN_USERS.remove(user.getUsername());
	}
	
	public static void removeUser(String username) {
		LOGGED_IN_USERS.remove(username);
	}
	
	
}
