  
package com.myspring.pro27.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.myspring.pro27.member.vo.MemberVO;


public interface MemberDAO {
	 public List selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 public MemberVO selectMember(String id) throws DataAccessException;
	 public int modMember(MemberVO memberVO) throws DataAccessException;
	 

}