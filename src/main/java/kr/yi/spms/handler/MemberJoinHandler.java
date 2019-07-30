package kr.yi.spms.handler;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.MemberDao;
import kr.yi.spms.model.Member;
import kr.yi.spms.util.MySqlSessionFactory;



public class MemberJoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/joinForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			req.setCharacterEncoding("utf-8");
			
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String regdate = req.getParameter("regdate");
			SqlSession sqlSession = null;	
			
			try {
				sqlSession = MySqlSessionFactory.openSession();
				MemberDao dao = sqlSession.getMapper(MemberDao.class);
				
				Member member = new Member();
				member.setMemberid(id);
				member.setName(name);
				member.setPassword(password);
				
				
				Member dbMember = dao.selectById(id);
				if(dbMember != null) { //id를 사용하는 user가 있음
					req.setAttribute("duplicatedId", true);
					return "/WEB-INF/view/joinForm.jsp";
				}
				dao.insert(member);
				sqlSession.commit();
				
				return "/WEB-INF/view/joinSuccess.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
				
			}			
			
		}
		return null;
	}

}
