package com.myspring.pro27.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeMember(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}