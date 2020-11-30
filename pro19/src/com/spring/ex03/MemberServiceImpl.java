package com.spring.ex03;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	public void setMemberDAO1(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void listMembers() {
		memberDAO.listMembers();
	}
}
