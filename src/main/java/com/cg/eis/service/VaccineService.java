package com.cg.eis.service;

import java.util.List;

import com.cg.eis.entities.Vaccine;
import com.cg.eis.exceptions.VaccineCreationException;
import com.cg.eis.exceptions.VaccineNotFoundException;

public interface VaccineService {

	public Vaccine addVaccine(Vaccine vaccine) throws VaccineCreationException;
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineNotFoundException;
	public boolean deleteVaccine(Vaccine vaccine);
	public Vaccine getVaccineByName(String vaccineName);
	public Vaccine getVaccineById(int vaccineId);
	public List<Vaccine> getAllVaccine();
}
