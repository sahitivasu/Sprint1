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

import com.cg.eis.dao.VaccineRegistrationDao;
import com.cg.eis.entities.Member;
import com.cg.eis.entities.VaccineRegistration;
import com.cg.eis.exceptions.VaccineRegistrationCreationException;
import com.cg.eis.exceptions.VaccineRegistrationNotFoundException;

@RestController
public class VaccineRegistrationController {

	@Autowired
	VaccineRegistrationDao vacRegDao;
	Logger log = org.slf4j.LoggerFactory.getLogger(VaccineRegistrationController.class);
	@PostMapping(path="/addVaccineRegistration")
	public VaccineRegistration addVaccineRegistration(@RequestBody VaccineRegistration reg) throws VaccineRegistrationCreationException {
		VaccineRegistration vacc=vacRegDao.addVaccineRegistration(reg);
		if(vacc!=null) {
			log.info("VaccineRegistration Added");
		}
		else {
			log.error("Sorry not able to add");
		}
		return vacc;
	}
	@PutMapping(path="/updateVaccineRegistration")
	public VaccineRegistration updateVaccineRegistration(@RequestBody VaccineRegistration reg) throws VaccineRegistrationNotFoundException {
		VaccineRegistration vacc=vacRegDao.updateVaccineRegistration(reg);
		if(vacc!=null) {
			log.info("VaccineRegistration updated");
		}
		else {
			log.error("Sorry not able to update");
		}
		return vacc;
	}
	@DeleteMapping(path="/deleteVaccineRegistration")
	public boolean deleteVaccineRegistration(@RequestBody VaccineRegistration reg) {
		boolean b=vacRegDao.deleteVaccineRegistration(reg);
		if(b==true) {
			log.info("VaccineRegistration deleted");
		}
		else {
			log.error("Sorry not able to delete");
		}
		return vacRegDao.deleteVaccineRegistration(reg);
	}
	@GetMapping(path="/getVaccineRegistration/{mobileno}")
	public VaccineRegistration getVaccineRegistration(@PathVariable Long mobileno) {
		log.info("VaccineRegistration details by mobileNo");
		return vacRegDao.getVaccineRegistration(mobileno);
	}
	@GetMapping(path="/getAllMember/{mobileno}")
	public List<Member> getAllMember(@PathVariable Long mobileno) {
		log.info("Getting all members");
		return vacRegDao.getAllMember(mobileno);
	}
	@GetMapping(path = "/getAllVaccineRegistrations")
	public List<VaccineRegistration> getAllVaccineRegistrations() {
		log.info("Getting All VaccineRegistrations");
		return vacRegDao.getAllVaccineRegistrations();
	}
}
