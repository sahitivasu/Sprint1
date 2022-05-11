package com.cg.eis.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="VaccineCount_Table")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class VaccineCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vaccineCountId;
	@OneToOne(cascade=CascadeType.ALL)
	private Vaccine vaccine;
	@DecimalMin(value="1" , message = "minimum value shoud be one")
	private int quantity;
	private double price;
}
