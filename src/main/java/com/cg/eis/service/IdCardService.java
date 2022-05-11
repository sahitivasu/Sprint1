package com.cg.eis.service;

import com.cg.eis.entities.IdCard;
import com.cg.eis.exceptions.IdCardCreationException;

public interface IdCardService {

	public IdCard addIdCard (IdCard idcard) throws IdCardCreationException;
	public IdCard getPanCardByNumber(String panNo);
	public IdCard getAdharCardByNo(long adharno);
}
