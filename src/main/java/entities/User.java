package entities;

import java.util.Map;

public class User {

	private int userId;
	
	private String username;
	
	private String password;
	
	public User() {
		
	}
	
	public static User parseMapToUser(Map<String, Object> userMap) {
		User user = new User();
		user.setUsername((String)userMap.get("username"));
		user.setPassword((String)userMap.get("password"));
		user.setUserId((Integer)userMap.get("user_id"));
		
		return user;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
