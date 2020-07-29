package db;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JDBCConnector {

	private String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS users(" +
			"user_id INT NOT NULL AUTO_INCREMENT, " +
			"username VARCHAR(16) NOT NULL UNIQUE, " +
			"password VARCHAR(255) NOT NULL, "
			+ "PRIMARY KEY (user_id) "
			+ ");";
	
	private String CREATE_CART_TABLE = "CREATE TABLE IF NOT EXISTS carts("
			+ "cart_id INT NOT NULL AUTO_INCREMENT, "
			+ "user_id INT, "
			+ "product_id INT, "
			+ "PRIMARY KEY (cart_id), "
			+ "FOREIGN KEY (user_id) REFERENCES users(user_id), "
			+ "FOREIGN KEY (product_id) REFERENCES products(product_id) "
			+ ");";
	
	private String CREATE_PRODUCTS_TABLE = "CREATE TABLE IF NOT EXISTS products("
			+ "product_id INT NOT NULL AUTO_INCREMENT, "
			+ "product_name VARCHAR(255) NOT NULL, "
			+ "product_description VARCHAR(255), "
			+ "product_price DOUBLE, "
			+ "product_seller VARCHAR(255), "
			+ "PRIMARY KEY (product_id) "
			+ ");";
	
	private Connection conn;

	//singleton
	private static volatile JDBCConnector instance = null;
	
	public static JDBCConnector getInstance() { 
		if(instance != null) {
			return instance;
		}
		synchronized(JDBCConnector.class) { 
			if(instance == null) {
				instance = new JDBCConnector();
			}
			return instance;
		}
	}
	
	private JDBCConnector() {
		init();
		createTables();
	}
	
	
	private void createTables() {
		executeQuery(CREATE_USERS_TABLE);
		executeQuery(CREATE_PRODUCTS_TABLE);
		executeQuery(CREATE_CART_TABLE);
		
	}

	private void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Properties props = new Properties();
			props.setProperty("user", "root");
			props.setProperty("password", "q6olinio6343");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?createDatabaseIfNotExist=true&useLegacyDatetimeCode=false&serverTimezone=UTC",props);

		}catch (Exception e) {		
			e.printStackTrace();
		}
	}
	
	public void executeQuery(String query, Object...datas) {
		try (Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(query)) {
				
			prepareStatement(pstmt, datas);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * executes query which RETURNS a result
	 * @param query - the query to be executed
	 * @param datas - all data that are send to the query
	 */
	public List<Map<String,Object>> executeQueryWithResult(String query, Object...datas) { 
		try(Statement stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(query)) {
			prepareStatement(pstmt, datas);
			ResultSet resultSet = pstmt.executeQuery();
			
			return parseResultSetsToMap(resultSet);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void prepareStatement(PreparedStatement pstmt, Object...datas) throws SQLException {
		for (int i = 0; i < datas.length; i++) {
			Object currentData = datas[i];
			if (currentData instanceof LocalDateTime) {
				pstmt.setTimestamp(i + 1, Timestamp.valueOf((LocalDateTime) currentData));
			}else {
				pstmt.setObject(i + 1, currentData);
			}
		}
	}
	
	/**
	 * parses the resultSet into list of maps with key = name of the column and value = value of the column in database
	 * note : each map represents an entity
	 * @param resultSet - the result set 
	 * @return - list of maps each of which represents an entity from database
	 * @throws SQLException - throws from result set
	 */
	private List<Map<String,Object>> parseResultSetsToMap (ResultSet resultSet) throws SQLException {
		List<Map<String,Object>> entities = new ArrayList<>();
		int colCount = resultSet.getMetaData().getColumnCount();
		while(resultSet.next()) {
			Map<String, Object> map = new HashMap<>();
			for (int i = 1; i <= colCount; i++) {
				String colName = resultSet.getMetaData().getColumnName(i);
				Object colValue = resultSet.getObject(colName);
				map.put(colName,colValue);	
			}			
			entities.add(map);	
		}
		return entities;
	}
}

