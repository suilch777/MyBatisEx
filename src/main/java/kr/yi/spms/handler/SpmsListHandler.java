package kr.yi.spms.handler;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.SpmsDao;
import kr.yi.spms.model.Spms;
import kr.yi.spms.model.SpmsPage;
import kr.yi.spms.util.MySqlSessionFactory;




public class SpmsListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String sPage = req.getParameter("page");//현재 선택한 페이지 번호
		int page = 1;
		if(sPage != null) {
			page = Integer.parseInt(sPage);
		}
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			SpmsDao dao = sqlSession.getMapper(SpmsDao.class);
			Map<String, Object> map = new HashMap<>();
			map.put("startRow", (page-1)*10);
			map.put("size",10);
			List<Spms> list = dao. selectListPage(map);
			int totalCount = dao.selectTotalCount();
			SpmsPage spmsPage = new SpmsPage(totalCount, page, 10, list);
			
			//req.setAttribute("list", list);
			req.setAttribute("spmsPage", spmsPage);
			System.out.println("listTest");
			
			return "/WEB-INF/view/spmsList.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return null;
	}

}
