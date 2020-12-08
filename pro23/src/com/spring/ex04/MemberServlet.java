package com.spring.ex04;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

@WebServlet("/mem4.do")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		String action = request.getParameter("action");
		String nextPage="";
		
		if(action==null || action.equals("listMembers")) { 
			List membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage="test03/listMembers.jsp";
			
		}else if(action.equals("selectMemberById")) { // 아이디는 유일키이기 때무에 중복이 안되므로, 무조건 하나만나오므로 selectOne이다
			String id = request.getParameter("value");
			memberVO = dao.selectMemberById(id);
			request.setAttribute("member", memberVO);
			nextPage = "test03/memberInfo.jsp";
			
		}else if(action.equals("selectMemberByPwd")) { // 비밀번호는 중복이가능하니까 여러개의 레코드값이 나오기때문에 list로 뽑아주는 것이다.
			String pwd = request.getParameter("value"); // member.xml에서 ParameterType이 된다. (int)
			List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
			request.setAttribute("membersList", membersList);
			nextPage = "test03/listMembers.jsp";					
		}else if(action.equals("insertMember")) { // 비밀번호는 중복이가능하니까 여러개의 레코드값이 나오기때문에 list로 뽑아주는 것이다.
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			dao.insertMember(memberVO);
			nextPage = "/mem4.do?action=listMembers"; //redirect 페이지					
		}else if(action.equals("insertMember2")) { // 비밀번호는 중복이가능하니까 여러개의 레코드값이 나오기때문에 list로 뽑아주는 것이다.
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			Map<String, String> memberMap = new HashMap<String, String>();
			memberMap.put("id", id);
			memberMap.put("pwd", pwd);
			memberMap.put("name", name);
			memberMap.put("email", email);
			dao.insertMember2(memberMap);
			nextPage = "/mem4.do?action=listMembers"; //redirect 페이지					
		}else if(action.equals("updateMember")) { // 비밀번호는 중복이가능하니까 여러개의 레코드값이 나오기때문에 list로 뽑아주는 것이다.
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setName(name);
			memberVO.setEmail(email);
			dao.updateMember(memberVO);
			nextPage = "/mem4.do?action=listMembers"; //redirect 페이지					
		}else if(action.equals("deleteMember")) { // 비밀번호는 중복이가능하니까 여러개의 레코드값이 나오기때문에 list로 뽑아주는 것이다.
			String id = request.getParameter("id");
			dao.deleteMember(id);
						
			nextPage = "/mem4.do?action=listMembers"; //redirect 페이지					
		}
		
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);	
		
	}
}