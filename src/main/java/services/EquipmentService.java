package services;

import java.util.List;

import entities.Equipment;

public interface EquipmentService {
	
	List<Equipment> getAll();
	
	Equipment getById(int id);
	
	void addEquipment(String equipmentName, String description, double price, String seller);
}
