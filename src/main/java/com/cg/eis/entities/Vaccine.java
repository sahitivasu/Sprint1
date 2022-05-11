package com.cg.eis.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Vaccine_Table")
public class Vaccine {

	@Id
	private int vaccineId;
	@NotBlank(message = "vaccineName should not be blank")
	private String vaccninName;
	private String description;
	public int getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}
	public String getVaccninName() {
		return vaccninName;
	}
	public void setVaccninName(String vaccninName) {
		this.vaccninName = vaccninName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
