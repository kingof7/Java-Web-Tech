package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController { // 반드시 상속받아야함 --> 그래야만 브라우저 요청한 메서드 호출이됨

		public ModelAndView login (HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			String userID = "";
			String passwd = "";
			ModelAndView mav = new ModelAndView();
			request.setCharacterEncoding("utf-8");
			userID = request.getParameter("userID");
			passwd = request.getParameter("passwd");
			
			mav.addObject("userID", userID); // 바인딩 -> 이것때매 setAttribute 안써도됨 -> result.jsp로 값을 보냄
			mav.addObject("passwd", passwd);
			mav.setViewName("result");
			
			return mav;
			
					
		}
}
