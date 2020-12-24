package com.myspring.pro27.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;

@Controller("memberController") //bean 자동 생성
@EnableAspectJAutoProxy
public class MemberControllerImpl extends MultiActionController implements MemberController {
	
	//id가 memberService인 빈을 memberService에 자동 주입
	@Autowired
	private MemberService memberService;
	//id가 memberVO인 빈을 memberVO에 주입
	@Autowired
	MemberVO memberVO;
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	@Override
	@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		
		logger.info("viewName:" + viewName);
		logger.debug("viewName:" + viewName);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	// 회원 추가
	@Override
	@RequestMapping(value="/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, // jsp에서 입력한 회원정보가, ModelAttribute를 통해 자동으로 member에 셋팅, "member"속성명으로 바인딩
			HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	@RequestMapping(value="/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id //전송된 ID를 id에 설정합니다.
			,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
			
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		//mav.addObject("deleteMessage","${member.id} 제거");		
		return mav;
	}
	
	//form: 회원가입, 수정
	@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET) //정규식을 이용해 요청명이 Form.do로 끝나면 form() 호출
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request); //modMemberForm (view이름)
		ModelAndView mav = new ModelAndView();
		if(viewName.equals("/member/modMemberForm")) { //회원수정
			String id = request.getParameter("id");
			MemberVO memberVO = memberService.findMember(id);
			mav.addObject("member", memberVO); //binding
		}
		mav.setViewName(viewName);
		return mav;
	}
	
	//회원정보 수정
	@Override
	@RequestMapping(value="/member/modMember.do", method = RequestMethod.POST)
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		bind(request, memberVO); // jsp에서 넘어온 hidden값이(2개이상일때) 첫 속성에 모두 바인딩되기때문에 2개이상이넘어오면 아래줄처럼 따로 셋팅
		//memberVO.setId(request.getParameter("id")); //jsp에서 hidden으로 따로넘겨준것을 셋팅, bind는 hidden값을 하나로 셋팅해버림
		
		System.out.println("id" + memberVO.getId());
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
			fileName = fileName.substring(fileName.lastIndexOf("/", 1), fileName.length()); //view이름을 listMember가아닌 member/listMember로 얻어옴
		}
		return fileName; // /viewName 으로 반환
	}

	

}