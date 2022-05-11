package com.cg.eis.service;

import java.util.List;

import com.cg.eis.entities.Appointment;
import com.cg.eis.exceptions.AppointmentCreationException;
import com.cg.eis.exceptions.AppointmentNotFoundException;

public interface AppointmentService {

	public Appointment addAppointment(Appointment app) throws AppointmentCreationException;
	public Appointment updateAppointment(Appointment app) throws AppointmentNotFoundException;
	public boolean deleteAppointment(Appointment app);
	public Appointment getAppointment(long bookingid);
	public List<Appointment> getAllAppointment();
}
