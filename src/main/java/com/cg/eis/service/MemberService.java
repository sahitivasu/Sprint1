package com.cg.eis.service;

import java.util.List;

import com.cg.eis.entities.Member;
import com.cg.eis.exceptions.MemberCreationException;
import com.cg.eis.exceptions.MemberNotFoundException;

public interface MemberService {

	public Member addMember(Member member) throws MemberCreationException;
	public Member updateMember(Member member) throws MemberNotFoundException;
	public boolean deleteMember(Member member);
	public List<Member> getMemberById (int idcardid);
	public Member getMemberByAdharNo(long adharno);
	public Member getMemberByPanNo(String panNo);
	public List<Member> getAllMember();
}
