package com.spring.member.service;


import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;

public interface MemberService {
	
	public void setMemberDAO(MemberDAO memberDAO);
	public List listMembers() throws DataAccessException;
}