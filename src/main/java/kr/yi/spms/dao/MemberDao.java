package kr.yi.spms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.yi.spms.model.Member;



public interface MemberDao {
	public void insert(Member member) throws SQLException;
	public Member selectById(String memberid) throws SQLException;
	public List<Member> selectList() throws SQLException;
	//password, memberid
	public void update(Map<String, Object> map) throws SQLException;

}
