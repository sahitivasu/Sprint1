package com.cg.eis.controller;

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

import com.cg.eis.dao.VaccinationCenterDao;
import com.cg.eis.entities.VaccinationCenter;
import com.cg.eis.exceptions.VaccinationCenterCreationException;
import com.cg.eis.exceptions.VaccinationCenterNotFoundException;

@RestController
public class VaccinationCenterController {

	@Autowired
	VaccinationCenterDao vacCntrDao;
	Logger log = org.slf4j.LoggerFactory.getLogger(VaccinationCenterController.class);
	@PostMapping(path="/addVaccineCenter")
	public VaccinationCenter addVaccineCenter(@RequestBody VaccinationCenter center) throws VaccinationCenterCreationException {
		VaccinationCenter vc=vacCntrDao.addVaccineCenter(center);
		if(vc!=null) {
			log.info("Vaccine center added");
		}
		else {
			log.error("Sorry not able to add");
		}
		return vc;
	}
	@PutMapping(path="/updateVaccineCenter")
	public VaccinationCenter updateVaccineCenter(@RequestBody VaccinationCenter center) throws VaccinationCenterNotFoundException {
		VaccinationCenter vc=vacCntrDao.updateVaccineCenter(center);
		if(vc!=null) {
			log.info("Vaccine center updated");
		}
		else {
			log.error("Sorry not able to update");
		}
		return vc;
	}
	@DeleteMapping(path="/deleteVaccineCenter")
	public boolean deleteVaccineCenter(@RequestBody VaccinationCenter center) {
		Boolean b = vacCntrDao.deleteVaccineCenter(center);
		if(b==true) {
			log.info("Vaccine center deleted");
		}
		else {
			log.error("Sorry not able to delete");
		}
		return b;
	}
	@GetMapping(path="/getVaccinationCenterById/{centerid}")
	public VaccinationCenter getVaccineCenter(@PathVariable Integer centerid) {
		log.info("Getting vaccinationcenter by Id");
		return vacCntrDao.getVaccineCenter(centerid);
	}
	@GetMapping(path = "/getAllVaccineCenters")
	public List<VaccinationCenter> getAllVaccineCenters(){
		log.info("getting vaccine centers");
		return 	vacCntrDao.getAllVaccineCenters();
	}
}
