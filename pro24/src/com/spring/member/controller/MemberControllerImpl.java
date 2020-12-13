package com.spring.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;

	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	// 회원 추가
	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		/*
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String email = request.getParameter("email");
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		memberVO.setName(name);
		memberVO.setEmail(email);
		 */
		bind(request, memberVO);
		int result = 0;
		result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	//회원 삭제
	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		response.setContentType("text/html; charset=UTF-8");		
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		//mav.addObject("deleteMessage","${member.id} 제거");		
		return mav;
	}
	
	//form: 회원가입, 수정
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request); //modMemberForm (view이름)
		ModelAndView mav = new ModelAndView();
		if(viewName.equals("/modMemberForm")) { //회원수정
			String id = request.getParameter("id");
			MemberVO memberVO = memberService.findMember(id);
			mav.addObject("member", memberVO); //binding
		}
		mav.setViewName(viewName);
		return mav;
	}
	
	//회원정보 수정
	@Override
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		bind(request, memberVO); // jsp에서 넘어온 hidden값이 첫 속성에 바인딩되기때문에 2개이상이넘어오면 아래줄처럼 따로 셋팅
		memberVO.setId(request.getParameter("id")); //jsp에서 hidden으로 따로넘겨준것을 셋팅, bind는 hidden값을 하나로 셋팅해버림
		
		System.out.println(memberVO.getId());
		int result = 0;
		result = memberService.updateMember(memberVO);
		System.out.println("result: " + result);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
						
		return mav;
	}	

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName; // /viewName 으로 반환
	}

	

}