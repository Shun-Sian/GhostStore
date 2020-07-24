package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import db.JDBCConnector;
import entities.Equipment;

public class EquipmentRepository {

	private static final String ADD_EQUIPMENT_QUERY = "INSERT INTO products (product_name, product_description, product_price)\n" + 
			"VALUES (?, ?, ?);";
	
	private static final String GET_ALL_QUERY = "SELECT * FROM products";

	
	public void addEquipment(String equipmentName, String equipmentDescription, double equipmentPrice) {
		JDBCConnector.getInstance().executeQuery(ADD_EQUIPMENT_QUERY, equipmentName, equipmentDescription, equipmentPrice);
	}
	
	public List<Equipment> getAll() {
		List<Map<String,Object>> returnVal = JDBCConnector.getInstance().executeQueryWithResult(GET_ALL_QUERY);
		List<Equipment> equipments = new ArrayList<>();
		
		for(Map<String,Object> rawDatabaseEntity : returnVal) {
			equipments.add(Equipment.parseToEntity(rawDatabaseEntity));
		}
		
		return equipments;
		
	}
}
