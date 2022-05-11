package com.cg.eis.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.eis.entities.Vaccine;
import com.cg.eis.entities.VaccineInventory;
import com.cg.eis.exceptions.VaccineInventoryCreationException;
import com.cg.eis.exceptions.VaccineInventoryNotFoundException;

public interface VaccineInventoryService  {

	public VaccineInventory addVaccineCount(VaccineInventory inv) throws VaccineInventoryCreationException;
	public VaccineInventory updateVaccineInventory(VaccineInventory inv) throws VaccineInventoryNotFoundException;
	public boolean deleteVVaccineInventory(VaccineInventory inv);
	public VaccineInventory getVaccineInventoryByCenter(int centerid);
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date);
	public List<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vaccine);
	public List<VaccineInventory> getAllVaccineInventory();
}
