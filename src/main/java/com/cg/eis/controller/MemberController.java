package com.cg.eis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.eis.dao.MemberDao;
import com.cg.eis.entities.Member;
import com.cg.eis.exceptions.MemberCreationException;
import com.cg.eis.exceptions.MemberNotFoundException;

@RestController
public class MemberController {

	@Autowired
	MemberDao membDao;
	Logger log = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	@PostMapping(path="/createMember")
	public Member addMember(@RequestBody Member member) throws MemberCreationException {
		Member mem=membDao.addMember(member);
		if(mem!=null) {
			log.info("Member added");
		}
		else {
			log.error("Sorry not able to add");
		}
		return mem;
	}
	@PutMapping(path="/updateMember")
	public Member updateMember(@RequestBody Member member) throws MemberNotFoundException {
		Member mem=membDao.updateMember(member);
		if(mem!=null) {
			log.info("Member updated");
		}
		else {
			log.error("Sorry not able to update");
		}
		return mem;
	}
	@DeleteMapping(path="/deleteMember")
	public boolean deleteMember(@RequestBody Member member) {
		boolean b=membDao.deleteMember(member);
		if(b==true) {
			log.info("Member deleted");
		}
		else {
			log.error("Sorry not able to delete");
		}
		return b;
	}
	@GetMapping(path="/getMemberById/{idcardid}")
	public List<Member> getMemberById(@PathVariable Integer idcardid) {
		log.info("Getting memeber details by Id");
		return membDao.getMemberById(idcardid);
	}
	@GetMapping(path="/getMemberByAdharNo/{adharno}")
	public Member getMemberByAdharNo(@PathVariable Long adharno) {
		log.info("Getting memeber details by AdarNo");
		return membDao.getMemberByAdharNo(adharno);
	}
	@GetMapping(path="/getMemberByPanNo/{panno}")
	public Member getMemberByPanNo(@PathVariable String panno) {
		log.info("Getting memeber details by Panno");
		return membDao.getMemberByPanNo(panno);
	}
	@GetMapping(path = "/getAllMember")
	public List<Member> getAllMember()
	{
		log.info("Getting All memebers");
		return 	membDao.getAllMember();
	}
}
