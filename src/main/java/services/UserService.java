package services;

import entities.User;

public interface UserService {
	
	/**
	 * Adds user to the database and returns it
	 * returns null if its not successful
	 * @param password
	 * @param username
	 * @return - the user or null
	 */
	User registerUser(String password, String username);
	
	/**
	 * Checks the username and password 
	 * if they belong to existing User
	 * @param username
	 * @param password
	 * @return - if not successful returns null
	 * otherwise returns the user that has logged
	 */
	User login(String username, String password);
	
	void logout(String username);
}
