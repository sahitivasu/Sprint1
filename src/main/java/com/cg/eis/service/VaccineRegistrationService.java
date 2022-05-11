package com.cg.eis.service;

import java.util.List;

import com.cg.eis.entities.Member;
import com.cg.eis.entities.VaccineRegistration;
import com.cg.eis.exceptions.VaccineRegistrationCreationException;
import com.cg.eis.exceptions.VaccineRegistrationNotFoundException;

public interface VaccineRegistrationService {

	public VaccineRegistration addVaccineRegistration (VaccineRegistration reg) throws VaccineRegistrationCreationException;
	public VaccineRegistration updateVaccineRegistration (VaccineRegistration reg) throws VaccineRegistrationNotFoundException;
	public boolean deleteVaccineRegistration (VaccineRegistration reg);
	public VaccineRegistration getVaccineRegistration (long mobileno);
	public List<Member> getAllMember(long mobileno);
	public List<VaccineRegistration> getAllVaccineRegistrations();
}
