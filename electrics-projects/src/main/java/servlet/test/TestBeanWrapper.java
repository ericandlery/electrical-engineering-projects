package servlet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.rc.GridBean;
import model.bean.test.TestBean;
import util.bean.BeanWrapperUtils;

@WebServlet(urlPatterns="/test/beant.do")
public class TestBeanWrapper extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GridBean gb=new GridBean();
		
		System.out.println(gb);
		
		gb=(GridBean)BeanWrapperUtils.wrapBeanFromReq(GridBean.class, req);
		
		System.out.println("gridbean="+gb);
		
		TestBean tb=new TestBean();
		System.out.println(tb);
		tb=(TestBean)BeanWrapperUtils.wrapBeanFromReq(TestBean.class, req);
		System.out.println(tb);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
