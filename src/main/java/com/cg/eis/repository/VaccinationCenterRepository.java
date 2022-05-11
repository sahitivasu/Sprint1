package com.cg.eis.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.eis.entities.VaccinationCenter;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer>{

	//public VaccinationCenter addVaccineCenter(VaccinationCenter center);
	@Transactional
	@Modifying
	@Query(value="update VaccinationCenter v set v.centername=?1,v.address=?2,v.city=?3,v.state=?4,v.pincode=?5 where v.code=?6")
	public int updateVaccineCenter(String nameCenter,String address,String city,String state,String pincode,int centerCode);
	//public boolean deleteVaccineCenter(VaccinationCenter center);
	@Query(value="select * from vaccination_center_table where code=?1",nativeQuery=true)
	public VaccinationCenter getVaccineCenter(int centerid);
	//public List<VaccinationCenter> getAllVaccineCenters();
}
