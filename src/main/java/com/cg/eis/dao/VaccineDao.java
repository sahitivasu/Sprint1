package com.cg.eis.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.controller.VaccineController;
import com.cg.eis.entities.Vaccine;
import com.cg.eis.exceptions.VaccineCreationException;
import com.cg.eis.exceptions.VaccineNotFoundException;
import com.cg.eis.repository.VaccineRepository;
import com.cg.eis.service.VaccineService;

@Service
public class VaccineDao implements VaccineService{

	@Autowired
	VaccineRepository vaccRepos;
	Logger log = org.slf4j.LoggerFactory.getLogger(VaccineController.class);
	@Override
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineCreationException {
		if(vaccRepos.existsById(vaccine.getVaccineId())) {
			throw new VaccineCreationException("This vaccine is already available");
		}
		else {
		return vaccRepos.save(vaccine);
		}
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineNotFoundException {
		Vaccine v = null;
		if(vaccRepos.existsById(vaccine.getVaccineId())) {
		if(vaccRepos.updateVaccine(vaccine.getVaccninName(),vaccine.getDescription(),vaccine.getVaccineId())==1) {
			v = vaccRepos.getById((int)vaccine.getVaccineId());
		}}
		else {
			throw new VaccineNotFoundException("Vaccine not found");
		}
		return v;
	}

	@Override
	public boolean deleteVaccine(Vaccine vaccine) {
		int vaccId = vaccine.getVaccineId();
		if(vaccRepos.existsById(vaccId)) {
			vaccRepos.deleteById(vaccId);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Vaccine getVaccineByName(String vaccineName) {
		return vaccRepos.getVaccineByName(vaccineName);
	}

	@Override
	public Vaccine getVaccineById(int vaccineId) {
		//return vaccRepos.getById(vaccineId);
		return vaccRepos.getVaccineById(vaccineId);
	}

	@Override
	public List<Vaccine> getAllVaccine() {
		List<Vaccine> lst = vaccRepos.findAll();
		return lst;
	}

}
