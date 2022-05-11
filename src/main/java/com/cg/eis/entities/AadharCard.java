package com.cg.eis.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="AadharCard_Table")
@DiscriminatorValue("ADHAR")
public class AadharCard extends IdCard{

	//@Id
	private long adharNo;
	private String figerprints;
	private String irisscan;
}
