package kr.yi.spms.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.yi.spms.controller.CommandHandler;
import kr.yi.spms.dao.MemberDao;
import kr.yi.spms.model.Member;
import kr.yi.spms.model.User;
import kr.yi.spms.util.MySqlSessionFactory;



public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/loginForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			System.out.println("login");
			String id = req.getParameter("id");
			String pass = req.getParameter("password");
			
			
			SqlSession sqlSession =null;
			
			try {
				
				sqlSession = MySqlSessionFactory.openSession();
				MemberDao dao = sqlSession.getMapper(MemberDao.class);
				Member member = dao.selectById(id);
				
				//id에 해당하는 회원이 있는가 확인
				if(member == null) { //회원 아님
					req.setAttribute("notJoin", true);
					return "/WEB-INF/view/loginForm.jsp";
				}
				//비밀번호가 일치하는가 ?
				if(member.getPassword().equals(pass) == false) { //비밀번호 일치하지 않음
					req.setAttribute("notMatchPassword", true);
					return "/WEB-INF/view/loginForm.jsp";
				}
				
				//로그인처리
				HttpSession session = req.getSession();
				User user = new User(id, member.getName());
				session.setAttribute("Auth", user);
				
				return "index.jsp";//홈화면
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}			
			
		}
		return null;
	}

}
