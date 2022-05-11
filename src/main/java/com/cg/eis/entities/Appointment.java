package com.cg.eis.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Appointment_Table")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingid;
	@NotNull(message = "This filed shoud not be null")
	private long mobileno;
	@OneToOne(cascade=CascadeType.ALL)
	private Member member;
	@OneToOne(cascade=CascadeType.ALL)
	private VaccinationCenter center;
	private LocalDate dateofbooking;
	private Slot slot;
	private boolean bookingstatus;
	public long getBookingid() {
		return bookingid;
	}
	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public LocalDate getDateofbooking() {
		return dateofbooking;
	}
	public void setDateofbooking(LocalDate dateofbooking) {
		this.dateofbooking = dateofbooking;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	public boolean isBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(boolean bookingstatus) {
		this.bookingstatus = bookingstatus;
	}
	
}
