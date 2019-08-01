package kr.yi.spms.handler;


import java.sql.Date;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.SpmsDao;
import kr.yi.spms.model.Spms;
import kr.yi.spms.model.User;
import kr.yi.spms.util.MySqlSessionFactory;



public class SpmsInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/spmsWriteForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
		
			
			String sName = req.getParameter("sp_name");
			String sContent = req.getParameter("content");
			String sDate = req.getParameter("startdate");
						
			String sDate2 = req.getParameter("enddate");
			
			
			String sStatus = req.getParameter("status");
			
			System.out.println(sDate);
			
			User user = (User)req.getSession().getAttribute("Auth");
			
			Spms spms = new Spms();
			
			spms.setSp_name(sName);
			spms.setContent(sContent);
			
			
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			spms.setStartdate(date.parse(sDate));
			
			
			SimpleDateFormat date2 = new SimpleDateFormat("yyyy-MM-dd");
			
			spms.setEnddate(date2.parse(sDate2));
			spms.setStatus(sStatus);
			
						
			SqlSession sqlSession = null;
			
			try {
				sqlSession = MySqlSessionFactory.openSession();
				
				SpmsDao dao = sqlSession.getMapper(SpmsDao.class);
				dao.insertSpms(spms);				
				
				sqlSession.commit();
				
				res.sendRedirect(req.getContextPath()+ "/spms/list.do");
				return null;//forward막힘
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
		}
		return null;
	}

}
