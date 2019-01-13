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
import service.rc.GridResultCalcService;
import util.bean.BeanWrapperUtils;
import util.file.MyFileUtils;
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
			
			List<List<Object>> iconList=null;
			GridBean gb=(GridBean)BeanWrapperUtils.wrapBeanFromReq(new GridBean(), req);
			GridResultCalcService grc=new GridResultCalcService();
			
			gb.setIconNames(MyFileUtils.getFileNamesFromRequestForRC("/resistor_circuit/images", req));
			
//			System.out.println(gb);
//			System.out.println(iconList);
			
			/*Calling the service to get the result.*/
			grc.processGridIcons(gb);
			
		}else {
			throw new RuntimeException("No actions can be taken.");
		}
				
	}

}
