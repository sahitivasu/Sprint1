package com.cg.eis.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.controller.VaccinationCenterController;
import com.cg.eis.entities.VaccinationCenter;
import com.cg.eis.exceptions.VaccinationCenterCreationException;
import com.cg.eis.exceptions.VaccinationCenterNotFoundException;
import com.cg.eis.repository.VaccinationCenterRepository;
import com.cg.eis.service.VaccinationCenterService;

@Service
public class VaccinationCenterDao implements VaccinationCenterService{

	@Autowired
	VaccinationCenterRepository vaccCentRepos;
	Logger log = org.slf4j.LoggerFactory.getLogger(VaccinationCenterController.class);
	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter center) throws VaccinationCenterCreationException {
		if(vaccCentRepos.existsById(center.getCode())) {
			throw new VaccinationCenterCreationException("This VaccinationCenter already exists");
		}
		else {
		return vaccCentRepos.save(center);
		}
	}

	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center) throws VaccinationCenterNotFoundException {
		VaccinationCenter c = null;
		if(vaccCentRepos.existsById(center.getCode())) {
		if(vaccCentRepos.updateVaccineCenter(center.getCentername(),center.getAddress(),center.getCity(),center.getState(),center.getPincode(),center.getCode())==1) {
			c=vaccCentRepos.getById(center.getCode());
		}}
		else {
			throw new VaccinationCenterNotFoundException("VaccinationCenter not found");
		}
		return c;
	}

	@Override
	public boolean deleteVaccineCenter(VaccinationCenter center) {
		int code = center.getCode();
		if(vaccCentRepos.existsById(code)) {
			vaccCentRepos.deleteById(code);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public VaccinationCenter getVaccineCenter(int centerid) {
		return vaccCentRepos.getVaccineCenter(centerid);
	}

	@Override
	public List<VaccinationCenter> getAllVaccineCenters() {
		List<VaccinationCenter> lst = vaccCentRepos.findAll();
		return lst;
	}

}
