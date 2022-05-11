package com.cg.eis.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.eis.entities.Member;
import com.cg.eis.entities.VaccineRegistration;

@Repository
public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration, Integer>{

	//public VaccineRegistration addVaccineRegistration (VaccineRegistration reg);
	@Transactional
	@Modifying
	@Query(value="update VaccineRegistration v set v.mobileno=?1,v.dateofregistration=?2 where v.vaccRegId=?3")
	public int updateVaccineRegistration (long reg,LocalDate regDate,int regId);
	//public boolean deleteVaccineRegistration (VaccineRegistration reg);
	@Query(value="select * from vaccine_registration_table where mobileno = ?1",nativeQuery=true)
	public VaccineRegistration getVaccineRegistration (long mobileno);
	//public List<Member> getAllMember(long mobileno);
	//public List<VaccineRegistration> getAllVaccineRegistrations();
	
}
