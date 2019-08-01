package kr.yi.spms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.SpmsDao;
import kr.yi.spms.util.MySqlSessionFactory;


public class SpmsDeleteHandler implements CommandHandler {

	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String sNo = req.getParameter("no");
		int no = Integer.parseInt(sNo);
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			SpmsDao dao = sqlSession.getMapper(SpmsDao.class);
					
			dao.deleteSpms(no);
			
			
			sqlSession.commit();
			
			return "list.do";
			
			
		} finally {
			sqlSession.close();
		}
		
	}

}
