package com.cg.eis.dao;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.controller.VaccineInventoryController;
import com.cg.eis.entities.VaccinationCenter;
import com.cg.eis.entities.Vaccine;
import com.cg.eis.entities.VaccineInventory;
import com.cg.eis.exceptions.VaccineInventoryCreationException;
import com.cg.eis.exceptions.VaccineInventoryNotFoundException;
import com.cg.eis.repository.VaccinationCenterRepository;
import com.cg.eis.repository.VaccineInventoryRepository;
import com.cg.eis.service.VaccineInventoryService;

@Service
public class VaccineInventoryDao implements VaccineInventoryService
{

	@Autowired
	VaccineInventoryRepository vaccInvRepos;
	Logger log = org.slf4j.LoggerFactory.getLogger(VaccineInventoryController.class);
	@Autowired
	VaccinationCenterRepository vaccCentRepos;
	@Override
	public VaccineInventory addVaccineCount(VaccineInventory inv) throws VaccineInventoryCreationException {
		if(vaccInvRepos.existsById(inv.getVaccineInventoryId())) {
			throw new VaccineInventoryCreationException("VaccineInventory already exists");
		}
		else {
		return vaccInvRepos.save(inv);
		}
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory inv) throws VaccineInventoryNotFoundException {
		VaccineInventory v = null;
		if(vaccInvRepos.existsById(inv.getVaccineInventoryId())) {
		if(vaccInvRepos.updateVaccineInventory(inv.getDate(),inv.getVaccineInventoryId())==1) {
			v= vaccInvRepos.getById(inv.getVaccineInventoryId());
		}}
		else {
			throw new VaccineInventoryNotFoundException("VaccineInventory not found");
		}
		return v;
	}

	@Override
	public boolean deleteVVaccineInventory(VaccineInventory inv) {
		int invId = inv.getVaccineInventoryId();
		if(vaccInvRepos.existsById(invId)) {
			vaccInvRepos.deleteById(invId);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public VaccineInventory getVaccineInventoryByCenter(int centerid) {
		//VaccinationCenter center = vaccCentRepos.getById(centerid);
		return vaccInvRepos.getVaccineInventoryByCenter(centerid);
		//return null;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date) {
		// TODO Auto-generated method stub
		List<VaccineInventory> lst = vaccInvRepos.getVaccineInventoryByDate(date);
		return lst;
		//return null;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vaccine) {
		//return vaccInvRepos.getVaccineInventoryByVaccine(vaccine);
		return null;
	}

	@Override
	public List<VaccineInventory> getAllVaccineInventory() {
		List<VaccineInventory> lst = vaccInvRepos.findAll();
		return lst;
	}

}
