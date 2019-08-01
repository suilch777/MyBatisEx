package kr.yi.spms.dao;


import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.yi.spms.model.Spms;
import kr.yi.spms.util.MySqlSessionFactory;



public class SpmsDaoTest {

	@Test
	public void testSelectListPage() {
		
			
			SqlSession sqlSession = null;
			
			try {
				sqlSession = MySqlSessionFactory.openSession();
				SpmsDao dao = sqlSession.getMapper(SpmsDao.class);
				Map<String, Object> map = new HashMap<>();
				map.put("startRow", (1)*10);
				map.put("size",10);
				List<Spms> list = dao. selectListPage(map);
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
		}

	

	@Test
	public void testSelectList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectBySpmsNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSpms() {
		fail("Not yet implemented");
	}

}
