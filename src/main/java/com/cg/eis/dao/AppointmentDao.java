package com.cg.eis.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.controller.AppointmentController;
import com.cg.eis.entities.Appointment;
import com.cg.eis.exceptions.AppointmentCreationException;
import com.cg.eis.exceptions.AppointmentNotFoundException;
import com.cg.eis.repository.AppointmentRepository;
import com.cg.eis.service.AppointmentService;

@Service
public class AppointmentDao implements AppointmentService{

	@Autowired
	AppointmentRepository appRepos;
	Logger log = org.slf4j.LoggerFactory.getLogger(AppointmentController.class);
	@Override
	public Appointment addAppointment(Appointment app) throws AppointmentCreationException {
		if(appRepos.existsById(app.getBookingid())) {
			throw new AppointmentCreationException("This Appointment is already available");
		}
		else {
		return appRepos.save(app);
		}
	}

	@Override
	public Appointment updateAppointment(Appointment app) throws AppointmentNotFoundException {
		Appointment a = null;
		if(appRepos.existsById(app.getBookingid())) {
		if(appRepos.updateAppointment(app.getMobileno(),app.getDateofbooking(),app.getSlot(),app.isBookingstatus(),app.getBookingid())==1) {
			a = appRepos.getById(app.getBookingid());
		}}
		else {
			throw new AppointmentNotFoundException("Appointment is not found");
		}
		return a;
	}

	@Override
	public boolean deleteAppointment(Appointment app) {
		long bookingId =  app.getBookingid();
		if(appRepos.existsById(bookingId)) {
			appRepos.deleteById(bookingId);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Appointment getAppointment(long bookingid) {
		
		//return appRepos.getById(bookingid);
		//return appRepos.getOne(bookingid);
		return appRepos.getAppointment(bookingid);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		List<Appointment> lst = appRepos.findAll();
		return lst;
	}

}
