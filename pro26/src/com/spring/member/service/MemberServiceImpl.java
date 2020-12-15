package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

@Service("memberService") //MemberServiceImpl 클래스를 이용해 id가 memberService인을 자동 생성함
@Transactional(propagation=Propagation.REQUIRED)
public class MemberServiceImpl  implements MemberService{
	   @Autowired // id가 memberDAO인 빈을 자동 주입
	   private MemberDAO memberDAO;

	   @Override
	   public List listMembers() throws DataAccessException {
	      List membersList = null;
	      membersList = memberDAO.selectAllMemberList();
	      return membersList;
	   }

	   @Override
	   public int addMember(MemberVO memberVO) throws DataAccessException {
	     return memberDAO.insertMember(memberVO);
	   }


	   @Override
	   public int removeMember(String id) throws DataAccessException {
		   
	      return memberDAO.deleteMember(id);
	   }

	@Override
	public MemberVO findMember(String id) throws DataAccessException {
		MemberVO memberVO = memberDAO.selectMember(id);
		return memberVO;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		return memberDAO.modMember(memberVO);
	}
}