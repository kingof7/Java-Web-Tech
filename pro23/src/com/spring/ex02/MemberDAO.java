package com.spring.ex02;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	public String selectName() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		String name = session.selectOne("mapper.member.selectName"); //하나의 데이터
		return name;
	}
	
	public int selectPwd() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int pwd = session.selectOne("mapper.member.selectPwd");
		return pwd;
	}
	
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> membersList = null;
		membersList = session.selectList("mapper.member.memResult");
		return membersList;
	}
	
//	 public List<HashMap<String, String>> selectAllMemberList() { 
//		sqlMapper = getInstance(); 
//     	SqlSession session = sqlMapper.openSession();
//		List<HashMap<String, String>> memlist = null; 
//   	memlist = session.selectList("mapper.member.selectAllMemberList"); 
//		return memlist; 
//	 }
	
}