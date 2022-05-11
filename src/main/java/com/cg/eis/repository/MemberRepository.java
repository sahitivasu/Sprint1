package com.cg.eis.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.eis.entities.IdCard;
import com.cg.eis.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

	//public Member addMember(Member member);
	@Query(value = "update Member m set m.dose1date=?1,m.dose2date=?2,m.dose1status=?3,m.dose2status=?4 where m.memberId = ?5")
	public int updateMember(LocalDate doseDate1,LocalDate doseDate2,boolean dose1Stat,boolean dose2Stat,int memberId);
	//public boolean deleteMember(Member member);
	
	  @Query(value ="select * from member_table where idcard_id=?1",nativeQuery=true)
	  public List<Member> getMemberById (int idcardid);
	  
	  @Query(value = "select * from member_table where idcard_id=(select id from id_table  where adhar_no=?1)",nativeQuery=true) 
	  public Member getMemberByAdharNo(long adharno);
		  
	  @Query(value = "select * from member_table where idcard_id=(select id from id_table  where pano_no=?1)",nativeQuery=true)
	  public Member getMemberByPanNo(String panNo);
		 
	 
	//public List<Member> getAllMember();
}
