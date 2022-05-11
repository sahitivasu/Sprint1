package com.cg.eis.service;

import java.util.List;

import com.cg.eis.entities.VaccinationCenter;
import com.cg.eis.exceptions.VaccinationCenterCreationException;
import com.cg.eis.exceptions.VaccinationCenterNotFoundException;

public interface VaccinationCenterService {

	public VaccinationCenter addVaccineCenter(VaccinationCenter center) throws VaccinationCenterCreationException;
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center) throws VaccinationCenterNotFoundException;
	public boolean deleteVaccineCenter(VaccinationCenter center);
	public VaccinationCenter getVaccineCenter(int centerid);
	public List<VaccinationCenter> getAllVaccineCenters();
}
