package services;

import java.util.List;

import entities.Equipment;

public interface EquipmentService {

	void addEquipment(Equipment equipment);
	
	List<Equipment> getAll();
}
