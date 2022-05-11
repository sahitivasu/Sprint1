package com.cg.eis.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.eis.controller.IdCardController;
import com.cg.eis.controller.MemberController;
import com.cg.eis.entities.Member;
import com.cg.eis.exceptions.MemberCreationException;
import com.cg.eis.exceptions.MemberNotFoundException;
import com.cg.eis.repository.MemberRepository;
import com.cg.eis.service.MemberService;

@Service
public class MemberDao implements MemberService{

	@Autowired
	MemberRepository memRepos;
	Logger log = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	@Override
	public Member addMember(Member member) throws MemberCreationException {
		if(memRepos.existsById(member.getMemberId())) {
			throw new MemberCreationException("This Member already exists");
		}
		else {
		return memRepos.save(member);
		}
	}

	@Override
	public Member updateMember(Member member) throws MemberNotFoundException {
		Member m = null;
		if(memRepos.existsById(member.getMemberId())) {
		if(memRepos.updateMember(member.getDose1date(),member.getDose2date(),member.isDose1status(),member.isDose2status(),member.getMemberId())==1) {
			m=memRepos.getById(member.getMemberId());
		}}
		else {
			throw new MemberNotFoundException("Member not found");
		}
		return m;
	}

	@Override
	public boolean deleteMember(Member member) {
		int memId = member.getMemberId();
		if(memRepos.existsById(memId)) {
			memRepos.deleteById(memId);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Member> getMemberById(int idcardid) {
		return (List<Member>) memRepos.getMemberById(idcardid);
		//return null;
	}

	@Override
	public Member getMemberByAdharNo(long adharno) {
		return memRepos.getMemberByAdharNo(adharno);
		//return null;
	}

	@Override
	public Member getMemberByPanNo(String panNo) {
		return memRepos.getMemberByPanNo(panNo);
		//return null;
	}

	@Override
	public List<Member> getAllMember() {
		List<Member> lst = memRepos.findAll();
		return lst;
	}

}
