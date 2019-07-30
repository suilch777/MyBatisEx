package kr.yi.spms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.yi.spms.model.Spms;



public interface SpmsDao {
	
	
	public List<Spms> selectListPage(Map<String, Object> map) throws SQLException;
	public List<Spms> selectList() throws SQLException;
	public void insertSpms(Spms spms)throws SQLException;
	public Spms selectBySpmsNo(int sp_no) throws SQLException;
	public void deleteSpms(int no)throws SQLException;
	public List<Spms> selectListPage1(Map<String, Object> map);
	public int selectTotalCount();
	

}
