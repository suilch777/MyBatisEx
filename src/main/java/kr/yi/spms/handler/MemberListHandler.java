package kr.yi.spms.handler;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.MemberDao;
import kr.yi.spms.model.Member;
import kr.yi.spms.util.MySqlSessionFactory;



public class MemberListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			MemberDao dao = sqlSession.getMapper(MemberDao.class);
			List<Member> list =  dao.selectList();
			req.setAttribute("list", list);
			
			return "/WEB-INF/view/memberList.jsp";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return null;
	}

}
