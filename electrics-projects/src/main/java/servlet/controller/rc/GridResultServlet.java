package servlet.controller.rc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.rc.GridBean;
import util.bean.BeanWrapperUtils;
import util.json.JacksonUtils;

@WebServlet(urlPatterns="/gridResult.do")
public class GridResultServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String actionType=req.getParameter("actionType");
		if("calcResult".equals(actionType)) {
			
			GridBean gb=(GridBean)BeanWrapperUtils.wrapBeanFromReq(new GridBean(), req);
			System.out.println(gb);
			
			System.out.println("JSON==="+JacksonUtils.jsonToList(gb.getIconJsonStr()));
			
		}
				
	}

}
