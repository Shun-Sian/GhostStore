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
	public void addEquipment(Equipment equipment) {
		//TODO Validate etc etc
		
		
		this.equipmentRepository.addEquipment(equipment.getName(), equipment.getDescription(), equipment.getPrice());
	}

	@Override
	public List<Equipment> getAll() {
		return this.equipmentRepository.getAll();
	}


}
