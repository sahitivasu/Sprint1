package com.cg.eis.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.controller.VaccineRegistrationController;
import com.cg.eis.entities.Member;
import com.cg.eis.entities.VaccineRegistration;
import com.cg.eis.exceptions.VaccineRegistrationCreationException;
import com.cg.eis.exceptions.VaccineRegistrationNotFoundException;
import com.cg.eis.repository.VaccineRegistrationRepository;
import com.cg.eis.service.VaccineRegistrationService;

@Service
public class VaccineRegistrationDao implements VaccineRegistrationService {

	@Autowired
	VaccineRegistrationRepository vaccRegRepos;
	Logger log = org.slf4j.LoggerFactory.getLogger(VaccineRegistrationController.class);
	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationCreationException {
		if(vaccRegRepos.existsById(reg.getVaccRegId())) {
			throw new VaccineRegistrationCreationException("VaccineRegistration already exists");
		}
		else {
		return vaccRegRepos.save(reg);}
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg) throws VaccineRegistrationNotFoundException {
		VaccineRegistration v = null;
		if(vaccRegRepos.existsById(reg.getVaccRegId())) {
		if(vaccRegRepos.updateVaccineRegistration(reg.getMobileno(),reg.getDateofregistration(),reg.getVaccRegId())==1) {
			v = vaccRegRepos.getById(reg.getVaccRegId());
		}}
		else {
			throw new VaccineRegistrationNotFoundException("VaccineRegistration not found");
		}
		return v;
	}

	@Override
	public boolean deleteVaccineRegistration(VaccineRegistration reg) {
		int vaccRegId = reg.getVaccRegId();
		if(vaccRegRepos.existsById(vaccRegId)) {
			vaccRegRepos.deleteById(vaccRegId);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public VaccineRegistration getVaccineRegistration(long mobileno) {
		return vaccRegRepos.getVaccineRegistration(mobileno);
		//return null;
	}

	@Override
	public List<Member> getAllMember(long mobileno) {
		VaccineRegistration reg = vaccRegRepos.getVaccineRegistration(mobileno);
		List<Member> lst = reg.getMemberlist();
		return lst;
		//return null;
	}

	@Override
	public List<VaccineRegistration> getAllVaccineRegistrations() {
		List<VaccineRegistration> lst = vaccRegRepos.findAll();
		return lst;
	}

}
