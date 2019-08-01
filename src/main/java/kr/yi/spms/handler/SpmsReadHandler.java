package kr.yi.spms.handler;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.SpmsDao;
import kr.yi.spms.model.Spms;
import kr.yi.spms.util.MySqlSessionFactory;






public class SpmsReadHandler implements CommandHandler {

	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		String sNo = req.getParameter("no");
		System.out.println(sNo);
		int no = Integer.parseInt(sNo);
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			SpmsDao dao = sqlSession.getMapper(SpmsDao.class);
			
			
			//get db article
			Spms  spms = dao.selectBySpmsNo(no);
			
			
			req.setAttribute("spms", spms);
			
			System.out.println("readTest");
			return "/WEB-INF/view/spmsRead.jsp";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
		return null;
	}

}
