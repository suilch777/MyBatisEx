package kr.yi.spms.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.book.controller.CommandHandler;
import kr.yi.book.dao.ProductDao;
import kr.yi.book.dao.ProductDaoImpl;
import kr.yi.book.model.Product;
import kr.yi.book.util.MySqlSessionFactory;

public class DetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String sNo = req.getParameter("no");
		int no = Integer.parseInt(sNo);
		
		SqlSession sqlSession = MySqlSessionFactory.openSession();
		ProductDao dao = ProductDaoImpl.getInstance(sqlSession);
		Product product = dao.selectByNo(no);
		req.setAttribute("product", product);
		sqlSession.close();
		return "/WEB-INF/view/product/detail.jsp";
	}
}
