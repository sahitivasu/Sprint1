package com.cg.eis.repository;


import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.eis.entities.Appointment;
import com.cg.eis.entities.Slot;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	@Transactional
	@Modifying
	@Query(value="update Appointment a set a.mobileno = ?1,a.dateofbooking=?2,a.slot=?3,a.bookingstatus=?4 where a.bookingid=?5")
	public int updateAppointment(long pNo,LocalDate bookDate,Slot slot,boolean stat,long appId);
	@Query(value="select * from appointment_table  where bookingid=?1",nativeQuery = true)
	public Appointment getAppointment(long bookingid);
	  
	 
}
