package com.cg.eis.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eis.dao.VaccineInventoryDao;
import com.cg.eis.entities.Vaccine;
import com.cg.eis.entities.VaccineInventory;
import com.cg.eis.exceptions.VaccineInventoryCreationException;
import com.cg.eis.exceptions.VaccineInventoryNotFoundException;

@RestController
public class VaccineInventoryController {

	@Autowired
	VaccineInventoryDao vacInvDao;
	Logger log = org.slf4j.LoggerFactory.getLogger(VaccineInventoryController.class);
	@PostMapping(path="/addVaccineCount")
	public VaccineInventory addVaccineCount(@RequestBody VaccineInventory inv) throws VaccineInventoryCreationException {
		VaccineInventory vacc=vacInvDao.addVaccineCount(inv);
		if(vacc!=null) {
			log.info("VaccineCount Added");
		}
		else {
			log.error("Sorry not able to add");
		}
		return vacc;
	}
	@PutMapping(path="/updateVaccineInventory")
	public VaccineInventory updateVaccineInventory(@RequestBody VaccineInventory inv) throws VaccineInventoryNotFoundException {
		VaccineInventory vacc=vacInvDao.updateVaccineInventory(inv);
		if(vacc!=null) {
			log.info("VaccineCount updated");
		}
		else {
			log.error("Sorry not able to update");
		}
		return vacInvDao.updateVaccineInventory(inv);
	}
	@DeleteMapping(path="/deleteVaccineInventory")
	public boolean deleteVaccineInventory(@RequestBody VaccineInventory inv) {
		boolean b=vacInvDao.deleteVVaccineInventory(inv);
		if(b==true) {
			log.info("VaccineInventory deleted");
		}
		else {
			log.error("Sorry not able to delete");
		}
		return b;
		
	}
	@GetMapping(path="/getVaccineInventoryByCenter/{centerid}")
	public VaccineInventory getVaccineInventoryByCenter(@PathVariable Integer centerid) {
		log.info("Getting Vaccine Inventory By Center");
		return vacInvDao.getVaccineInventoryByCenter(centerid);	
	}
	@GetMapping(path = "/getVaccineInventoryByDate/{date}")
	public List<VaccineInventory> getVaccineInventoryByDate(@PathVariable String date) {
		log.info("Getting Vaccine Inventory By Date");
		LocalDate d= LocalDate.parse(date);
		return vacInvDao.getVaccineInventoryByDate(d);
	}
	@GetMapping(path = "/getVaccineInventoryByVaccine")
	public List<VaccineInventory> getVaccineInventoryByVaccine(@RequestBody Vaccine vaccine) {
		log.info("Getting Vaccine Inventory By Vaccine");
		return vacInvDao.getVaccineInventoryByVaccine(vaccine);
	}
	@GetMapping(path = "/getAllVaccineInventory")
	public List<VaccineInventory> getAllVaccineInventory() {
		log.info("Getting All Vaccine Inventory");
		return vacInvDao.getAllVaccineInventory();
		
	}
}
