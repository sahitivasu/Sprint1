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
//@Table(name="PanCard_Table")
@DiscriminatorValue("PAN")
public class PanCard extends IdCard{

	//@Id
	private String panoNo;
}
