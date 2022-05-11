package com.cg.eis.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.eis.entities.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine,Integer>{

	//public Vaccine addVaccine(Vaccine vaccine);
	@Transactional
	@Modifying
	@Query(value="update Vaccine v set v.vaccninName=?1,v.description=?2 where v.vaccineId=?3")
	public int updateVaccine(String name,String desc,int vaccine);
	//public boolean deleteVaccine(Vaccine vaccine);
	@Query(value="select * from vaccine_table where vaccnin_name=?1",nativeQuery=true)
	public Vaccine getVaccineByName(String vaccineName);
	@Query(value="select * from vaccine_table where vaccine_id=?1",nativeQuery=true)
	public Vaccine getVaccineById(int vaccineId);
	//public List<Vaccine> getAllVaccine();
}
