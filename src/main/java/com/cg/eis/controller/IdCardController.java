package com.cg.eis.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eis.dao.IdCardDao;
import com.cg.eis.entities.IdCard;
import com.cg.eis.exceptions.IdCardCreationException;

@RestController
public class IdCardController {

	@Autowired
	IdCardDao idDao;
	Logger log = org.slf4j.LoggerFactory.getLogger(IdCardController.class);
	@PostMapping(path="/createIdCard")
	public IdCard createIdCard(@RequestBody IdCard idcard) throws IdCardCreationException
	{
		IdCard id=idDao.addIdCard(idcard);
		if(id!=null) {
			log.info("IdCard added");
		}
		else {
			log.error("Sorry not able add IDCard");
		}
		return id;
	}
	@GetMapping(path="/getPanCardByNumber/{panNo}")
	public IdCard getPanCardByNumber(@PathVariable String panNo) {
		log.info("IdCard fetched by Pan No");
		return idDao.getPanCardByNumber(panNo);
	}
	@GetMapping(path="/getAdharCardByNo/{adharno}")
	public IdCard getAdharCardByNo(@PathVariable Long adharno) {
		log.info("IdCard fetched by Adhar No");
		return idDao.getAdharCardByNo(adharno);
	}
}
