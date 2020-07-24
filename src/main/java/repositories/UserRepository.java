package repositories;

import java.util.List;
import java.util.Map;

import db.JDBCConnector;
import entities.User;

public class UserRepository {
	
	private static final String INSERT_QUERY = "INSERT INTO users (username, password)\n" + 
			"VALUES (?, ?);";
	
	private static final String SELECT_BY_USERNAME = "SELECT user_id, username, password \n" + 
			"FROM users WHERE username=?;";
	
	private static final String DELETE_BY_USERNAME = "DELETE FROM users WHERE username=?;";
			
	public User addUser(User user) {
		JDBCConnector.getInstance().executeQuery(INSERT_QUERY, user.getUsername(), user.getPassword());
		return user;
	}
	
	public void deleteUser(User user) {
		JDBCConnector.getInstance().executeQuery(DELETE_BY_USERNAME, user.getUsername());
	}
	
	public User getUser(String username) {
		List<Map<String,Object>> us = JDBCConnector.getInstance().executeQueryWithResult(SELECT_BY_USERNAME, username);
		if(us.isEmpty()) {
			return null;
		}else {
			return User.parseMapToUser(us.get(0));
		}
	}
	
}
