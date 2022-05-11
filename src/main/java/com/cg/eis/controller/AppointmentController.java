package com.cg.eis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eis.dao.AppointmentDao;
import com.cg.eis.entities.Appointment;
import com.cg.eis.exceptions.AppointmentCreationException;
import com.cg.eis.exceptions.AppointmentNotFoundException;

@RestController
public class AppointmentController {

	@Autowired
	AppointmentDao appDao;
	Logger log = org.slf4j.LoggerFactory.getLogger(AppointmentController.class);
	@PostMapping(path="/createAppointment")
	/*
	 * Add appointment method is written
	 * if the output is not null then Appointment created is shown in log
	 * else Sorry not able to create is shown in log
	 */
	public Appointment createAppointment(@RequestBody Appointment app) throws AppointmentCreationException
	{
		Appointment ap=appDao.addAppointment(app);
		if(ap!=null) {
			log.info("Appointment created");
		}
		else {
			log.error("Sorry not able to create");
		}
		return ap;
	}
	@PutMapping(path="/updateAppointment")
	public Appointment updateAppointment(@RequestBody Appointment app) throws AppointmentNotFoundException
	{
		Appointment ap = appDao.updateAppointment(app);
		if(ap!=null) {
			log.info("Information Updated");
		}
		else {
			log.error("Sorry not able to update");
		}
		return ap;
	}
	@DeleteMapping(path="/deleteAppointment")
	public boolean deleteAppointment(@RequestBody Appointment app) {
		boolean b = appDao.deleteAppointment(app);
		if(b==true) {
			log.info("Appointment deleted");
		}
		else {
			log.error("Sorry not able to delete");
		}
		return b;
	}
	@GetMapping(path="/getAppointmentById/{bookingId}")
	public Appointment getAppointmentById(@PathVariable Long bookingId){
		log.info("Appointment is fetched by Id");
		return appDao.getAppointment(bookingId);
	}
	@GetMapping(path = "/getAllAppointment")
	public List<Appointment> getAllAppointment()
	{
		log.info("List of Appointments are fetched");
		return 	appDao.getAllAppointment();
	}
}
