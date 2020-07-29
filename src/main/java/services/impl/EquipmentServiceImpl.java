package services.impl;

import java.util.List;

import entities.Equipment;
import repositories.EquipmentRepository;
import services.EquipmentService;

public class EquipmentServiceImpl implements EquipmentService{

	 private final EquipmentRepository equipmentRepository;
	
	 
	 public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
		 this.equipmentRepository = equipmentRepository;
	 }
	 	
	 @Override
	 public void addEquipment(String equipmentName, String description, double price, String seller) {
		this.equipmentRepository.addEquipment(equipmentName, description, price, seller);
		 
	 }

	@Override
	public List<Equipment> getAll() {
		return this.equipmentRepository.getAll();
	}

	@Override
	public Equipment getById(int id) {
		return this.equipmentRepository.findById(id);
	}



}
