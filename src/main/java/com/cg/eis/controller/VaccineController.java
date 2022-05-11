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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eis.dao.VaccineDao;
import com.cg.eis.entities.Vaccine;
import com.cg.eis.exceptions.VaccineCreationException;
import com.cg.eis.exceptions.VaccineNotFoundException;

@RestController
@RequestMapping("/api")
public class VaccineController {

	@Autowired
	VaccineDao vacDao;
	Logger log = org.slf4j.LoggerFactory.getLogger(VaccineController.class);
	@PostMapping(path="/addVaccine")
	public Vaccine addVaccine(@RequestBody Vaccine vac) throws VaccineCreationException {
		Vaccine vacc=vacDao.addVaccine(vac);
		if(vacc!=null) {
			log.info("Vaccine Added");
		}
		else {
			log.error("Sorry not able to add");
		}
		return vacc;
	}
	@PutMapping(path="/updateVaccine")
	public Vaccine updateVaccine(@RequestBody Vaccine vac) throws VaccineNotFoundException {
		Vaccine vacc=vacDao.updateVaccine(vac);
		if(vacc!=null) {
			log.info("Vaccine Updated");
		}
		else {
			log.error("Sorry not able to update");
		}
		return vacc;
	}
	@DeleteMapping(path="/deleteVaccine")
	public boolean deleteVaccine(@RequestBody Vaccine vac) {
		boolean b=vacDao.deleteVaccine(vac);
		if(b==true) {
			log.info("Vaccine deleted");
		}
		else {
			log.error("Sorry not able to delete");
		}
		return b;	
	}
	@GetMapping(path="/getVaccineByName/{vaccineName}")
	public Vaccine getVaccineByName(@PathVariable String vaccineName) {
		log.info("Vaccine details by Name");
		return vacDao.getVaccineByName(vaccineName);
	}
	@GetMapping(path="/getVaccineById/{vaccineId}")
	public Vaccine getVaccineById(@PathVariable Integer vaccineId) {
		log.info("Vaccine details by Id");
		return vacDao.getVaccineById(vaccineId);
	}
	@GetMapping(path = "/getAllVaccine")
	public List<Vaccine> getAllVaccine() {
		log.info("Vaccine details");
		return vacDao.getAllVaccine();
	}
}
