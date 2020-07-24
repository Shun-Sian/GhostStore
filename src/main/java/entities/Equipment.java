package entities;

import java.util.Map;

public class Equipment {

	private int id;
	
	private String name;
	
	private double price;
	
	private String description;
	
	public Equipment() {
		
	}
	
	public static Equipment parseToEntity(Map<String, Object> databaseEntry) {
		Equipment equipment = new Equipment();
		equipment.setId((Integer)databaseEntry.get("product_id"));
		equipment.setName((String)databaseEntry.get("product_name"));
		equipment.setDescription((String)databaseEntry.get("product_description"));
		equipment.setPrice((Double)databaseEntry.get("product_price"));
		return equipment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
