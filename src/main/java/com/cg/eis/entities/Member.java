package com.cg.eis.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Member_Table")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberId;
	@OneToOne(cascade=CascadeType.ALL)
	private IdCard idcard;
	private boolean dose1status;
	private boolean dose2status;
	private LocalDate dose1date;
	private LocalDate dose2date;
	@OneToOne(cascade=CascadeType.ALL)
	private Vaccine vaccine;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public IdCard getIdcard() {
		return idcard;
	}
	public void setIdcard(IdCard idcard) {
		this.idcard = idcard;
	}
	public boolean isDose1status() {
		return dose1status;
	}
	public void setDose1status(boolean dose1status) {
		this.dose1status = dose1status;
	}
	public boolean isDose2status() {
		return dose2status;
	}
	public void setDose2status(boolean dose2status) {
		this.dose2status = dose2status;
	}
	public LocalDate getDose1date() {
		return dose1date;
	}
	public void setDose1date(LocalDate dose1date) {
		this.dose1date = dose1date;
	}
	public LocalDate getDose2date() {
		return dose2date;
	}
	public void setDose2date(LocalDate dose2date) {
		this.dose2date = dose2date;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	
}
