package com.cg.eis.dao;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.controller.AppointmentController;
import com.cg.eis.controller.IdCardController;
import com.cg.eis.entities.IdCard;
import com.cg.eis.exceptions.IdCardCreationException;
import com.cg.eis.repository.IdCardRepository;
import com.cg.eis.service.IdCardService;

@Service
public class IdCardDao implements IdCardService {

	@Autowired
	IdCardRepository idRepos;
	Logger log = org.slf4j.LoggerFactory.getLogger(IdCardController.class);
	@Override
	public IdCard addIdCard(IdCard idcard) throws IdCardCreationException {
		if(idRepos.existsById(idcard.getId())) {
			throw new IdCardCreationException("This IdCard is already available");
		}
		else {
		return idRepos.save(idcard);
		}
	}

	@Override
	public IdCard getPanCardByNumber(String panNo) {
		return idRepos.getPanCardByNumber(panNo);
	}

	@Override
	public IdCard getAdharCardByNo(long adharno) {
		return idRepos.getAdharCardByNo(adharno);
	}

}
