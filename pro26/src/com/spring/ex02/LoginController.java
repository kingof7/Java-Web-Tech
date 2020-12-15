package com.spring.ex02;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	@RequestMapping(value = { "/test/loginForm.do", "/test/loginForm2.do" }, method = { RequestMethod.GET })
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
//    @RequestMapping(value = "/test/login.do", method={RequestMethod.GET,RequestMethod.POST}) //GET, POST 모두 처리한다
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("result");
//		String userID = request.getParameter("userID");
//		String userName = request.getParameter("userName");
//		mav.addObject("userID", userID);
//		mav.addObject("userName", userName);
//
//		return mav;
//	}

//	@RequestMapping(value = "/test/login.do", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView login(@RequestParam("userID") String userID, 	//바로 셋팅
//			                  @RequestParam("userName") String userName,
//			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("result");
//		
//		// String userID = request.getParameter("userID");
//		// String userName = request.getParameter("userName");
//		
//		System.out.println("userID: "+userID);
//		System.out.println("userName: "+userName);
//		mav.addObject("userID", userID);
//		mav.addObject("userName", userName);
//		return mav;
//	}
	
	
	@RequestMapping(value = "/test/login.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(@RequestParam("userID") String userID, //true가 기본값
                               @RequestParam(value="userName", required=true) String userName, //true니까 반드시 셋팅해야함
			                   @RequestParam(value="email", required=false) String email,	// null
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		
		// String userID = request.getParameter("userID");
		// String userName = request.getParameter("userName");
		
		System.out.println("userID: "+ userID);
		System.out.println("userName: "+ userName);
		System.out.println("email: "+ email);
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		return mav;
	}
	
	
	@RequestMapping(value = "/test/login3.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login3(@RequestParam HashMap<String, String> info, //RequestParam 여러번하지않고 info라는 변수로 (Map으로) 셋팅
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		String userID = info.get("userID");
		String userName = info.get("userName");
		System.out.println("userID: "+userID);
		System.out.println("userName: "+userName);
		
		mav.addObject("info", info);
		mav.setViewName("result");
		return mav;
	}
	
	@RequestMapping(value = "/test/login4.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO, //info를 이용해 바로 JSP에서 LoginVO 속성에 접근할 수 있음
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		System.out.println("userID: "+loginVO.getUserID());
		System.out.println("userName: "+loginVO.getUserName());
		mav.setViewName("result");
		return mav;
	}
	   
	@RequestMapping(value = "/test/login5.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login5(Model model, //model은 model.addAttribute로 mav.addObject와 같은기능 // Model 클래스는 View정보를 설정할 필요없을때(mav.setViewName) 사용하면 편리함
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		model.addAttribute("userID", "hong");
		model.addAttribute("userName", "홍길동");
		return "result";
	}	
}