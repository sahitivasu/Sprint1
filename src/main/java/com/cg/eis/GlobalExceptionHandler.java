package com.cg.eis;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.eis.exceptions.AppointmentCreationException;
import com.cg.eis.exceptions.AppointmentNotFoundException;
import com.cg.eis.exceptions.ErrorMessage;
import com.cg.eis.exceptions.IdCardCreationException;
import com.cg.eis.exceptions.MemberCreationException;
import com.cg.eis.exceptions.MemberNotFoundException;
import com.cg.eis.exceptions.VaccinationCenterCreationException;
import com.cg.eis.exceptions.VaccinationCenterNotFoundException;
import com.cg.eis.exceptions.VaccineCreationException;
import com.cg.eis.exceptions.VaccineInventoryCreationException;
import com.cg.eis.exceptions.VaccineInventoryNotFoundException;
import com.cg.eis.exceptions.VaccineNotFoundException;
import com.cg.eis.exceptions.VaccineRegistrationCreationException;
import com.cg.eis.exceptions.VaccineRegistrationNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AppointmentCreationException.class)
	public @ResponseBody ErrorMessage checkAppointmentCreationException(AppointmentCreationException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(AppointmentNotFoundException.class)
	public @ResponseBody ErrorMessage checkAppointmentNotFoundException(AppointmentNotFoundException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(IdCardCreationException.class)
	public @ResponseBody ErrorMessage checkIdCardCreationException(IdCardCreationException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(MemberCreationException.class)
	public @ResponseBody ErrorMessage checkMemberCreationException(MemberCreationException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(MemberNotFoundException.class)
	public @ResponseBody ErrorMessage checkMemberNotFoundException(MemberNotFoundException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(VaccinationCenterCreationException.class)
	public @ResponseBody ErrorMessage checkVaccinationCenterCreationException(VaccinationCenterCreationException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(VaccinationCenterNotFoundException.class)
	public @ResponseBody ErrorMessage checkVaccinationCenerNotFoundException(VaccinationCenterNotFoundException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(VaccineCreationException.class)
	public @ResponseBody ErrorMessage checkVaccineCreationException(VaccineCreationException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(VaccineNotFoundException.class)
	public @ResponseBody ErrorMessage checkVaccineNotFoundException(VaccineNotFoundException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(VaccineInventoryCreationException.class)
	public @ResponseBody ErrorMessage checkVaccineInventoryCreationException(VaccineInventoryCreationException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(VaccineInventoryNotFoundException.class)
	public @ResponseBody ErrorMessage checkVaccineInventoryNotFoundException(VaccineInventoryNotFoundException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(VaccineRegistrationCreationException.class)
	public @ResponseBody ErrorMessage checkVaccineRegistrationCreationException(VaccineRegistrationCreationException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
	@ExceptionHandler(VaccineRegistrationNotFoundException.class)
	public @ResponseBody ErrorMessage checkVaccineRegistrationNotFoundException(VaccineRegistrationNotFoundException e) {
	
		ErrorMessage error1 = new ErrorMessage(LocalDateTime.now(), e.getMessage());
		return error1;
	}
}
