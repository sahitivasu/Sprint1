package com.cg.eis.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="VaccineRegistration_Table")
public class VaccineRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vaccRegId;
	@NotNull(message = "This filed shoud not be null")
	private long mobileno;
	private LocalDate dateofregistration;
	@OneToMany(cascade=CascadeType.PERSIST)
	@JsonIgnore
	private List<Member> memberlist;
	public int getVaccRegId() {
		return vaccRegId;
	}
	public void setVaccRegId(int vaccRegId) {
		this.vaccRegId = vaccRegId;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public LocalDate getDateofregistration() {
		return dateofregistration;
	}
	public void setDateofregistration(LocalDate dateofregistration) {
		this.dateofregistration = dateofregistration;
	}
	public List<Member> getMemberlist() {
		return memberlist;
	}
	public void setMemberlist(List<Member> memberlist) {
		this.memberlist = memberlist;
	}
	
}
