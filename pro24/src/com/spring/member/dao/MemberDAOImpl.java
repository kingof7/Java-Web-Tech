package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;


public class MemberDAOImpl implements MemberDAO {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mappers.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mappers.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result =  sqlSession.delete("mappers.member.deleteMember", id);
		return result;
	}

	@Override
	public MemberVO selectMember(String id) throws DataAccessException {
		MemberVO memberVO = (MemberVO) sqlSession.selectOne("mappers.member.selectMemberById", id);
		return memberVO;
	}

	@Override
	public int modMember(MemberVO memberVO) throws DataAccessException {
		System.out.println("member ID: "+ memberVO.getId());
		int result = sqlSession.update("mappers.member.updateMember", memberVO);
		System.out.println("daoimpl result: " + result);
		return result;
	}
}