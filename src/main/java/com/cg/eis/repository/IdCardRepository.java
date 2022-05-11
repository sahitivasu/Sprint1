package com.cg.eis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.eis.entities.IdCard;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Integer> {

	//public IdCard addIdCard (IdCard idcard);
	@Query(value="select id from IdCard id where id.panoNo=?1")
	public IdCard getPanCardByNumber(String panNo);
	@Query(value="select id from IdCard id where id.adharNo=?1")
	public IdCard getAdharCardByNo(long adharno);
}
