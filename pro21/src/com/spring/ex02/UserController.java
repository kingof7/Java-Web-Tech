package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController { // 반드시 상속받아야함 --> 그래야만 브라우저 요청한 메서드 호출이됨

		public ModelAndView login (HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			String userID = "";
			String passwd = "";
			String viewName = getViewName(request); // request를 getViewName 메서드에 인자로 넘김, 호출
			
			ModelAndView mav = new ModelAndView();
			request.setCharacterEncoding("utf-8");
			userID = request.getParameter("userID");
			passwd = request.getParameter("passwd");
			
			mav.addObject("userID", userID); // 바인딩 -> 이것때매 setAttribute 안써도됨 -> result.jsp로 값을 보냄
			mav.addObject("passwd", passwd);
			mav.setViewName(viewName); // 요청이 login.do니까 login.jsp를 반환함
			
			return mav;
								
		}
		
		public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			ModelAndView mav = new ModelAndView();
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			mav.addObject("id", id); // 바인딩, 값 지정
			mav.addObject("pwd", pwd);
			mav.addObject("name", name);
			mav.addObject("email", email);
			mav.setViewName("memberInfo"); // view 지정
			return mav;
			
			}
		
		public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = getViewName(request);
			return new ModelAndView(viewName); // 모델엔뷰에 뷰를 넘겨줌 -> loginForm.jsp를 뿌려줌		
		}
		
		// serViewName 메서드 안에 view이름을 직접입력하지 않고 view를 반환하는 메서드		
		private String getViewName(HttpServletRequest request) throws Exception {
			String contextPath = request.getContextPath();
			String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
			if(uri == null || uri.trim().equals("")) {
				uri = request.getRequestURI();
			}
			
			int begin = 0;
			if(!((contextPath==null)||("".equals(contextPath)))) {
				begin = contextPath.length();
			}
			
			int end;
			if(uri.indexOf(";")!=-1) {
				end = uri.indexOf(";");
			}else if(uri.indexOf("?")!=-1) {
				end = uri.indexOf("?");
			}else {
				end = uri.length();
			}
			
			String fileName = uri.substring(begin, end);
			if(fileName.indexOf(".")!=-1) {
				fileName=fileName.substring(0, fileName.lastIndexOf(".")); // .do 앞에있는 요청명을 얻어오는 과정
			}
			if(fileName.lastIndexOf("/")!=-1) {
				fileName=fileName.substring(fileName.lastIndexOf("/"), fileName.length());
			}
			
			return fileName; //View 이름 요청
						
		}
		
}
