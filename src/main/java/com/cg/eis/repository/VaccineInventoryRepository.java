package com.cg.eis.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.eis.entities.VaccinationCenter;
import com.cg.eis.entities.Vaccine;
import com.cg.eis.entities.VaccineInventory;

@Repository
public interface VaccineInventoryRepository extends JpaRepository<VaccineInventory, Integer>{

	//public VaccineInventory addVaccineCount(VaccineInventory inv);
	@Transactional
	@Modifying
	@Query(value="update VaccineInventory v set v.date=?1 where v.vaccineInventoryId=?2")
	public int updateVaccineInventory(LocalDate invDate,int id);
	//public boolean deleteVaccineInventory(VaccineInventory inv);
	@Query(value = "select * from vaccine_inventory_table  where center_code=?1",nativeQuery=true)
	public VaccineInventory getVaccineInventoryByCenter(int centerid);
	@Query(value="select * from vaccine_inventory_table where date=?1",nativeQuery=true)
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date);
	//@Query(value = "select * from VaccineInventory v where v.vaccine = ?1")
	//public List<VaccineInventory> getVaccineInventoryByVaccine(Vaccine vaccine);
	//public List<VaccineInventory> getAllVaccineInventory();
}
