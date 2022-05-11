package com.cg.eis.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="VaccineInventory_Table")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class VaccineInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vaccineInventoryId;
	@OneToOne(cascade=CascadeType.ALL)
	private VaccinationCenter center;
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<VaccineCount> vaccinelist;
	private LocalDate date;
	public int getVaccineInventoryId() {
		return vaccineInventoryId;
	}
	public void setVaccineInventoryId(int vaccineInventoryId) {
		this.vaccineInventoryId = vaccineInventoryId;
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<VaccineCount> getVaccinelist() {
		return vaccinelist;
	}
	public void setVaccinelist(List<VaccineCount> vaccinelist) {
		this.vaccinelist = vaccinelist;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
