package servlet.controller.rc.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.rc.IconFunctions;
import util.json.JacksonUtils;

@WebServlet(urlPatterns="/specialBlocksAjax.do")
public class SpecialBlocksAjax extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType=req.getParameter("actionType");
		
		/*Get special blocks.*/
		if("getSpecialBlocks".equals(actionType)) {
			List<String> specialBlocks=new ArrayList<>();
			
			specialBlocks.add(IconFunctions.RESISTOR_H.getIcon());
			specialBlocks.add(IconFunctions.RESISTOR_V.getIcon());
			System.out.println(specialBlocks);
			
			resp.setContentType("application/json");
			PrintWriter out=resp.getWriter();
			
			out.print(JacksonUtils.listToJson(specialBlocks));
			
			out.flush();
		}else {
			throw new RuntimeException("SpecialBlocksAjax Error");
		}
	}

}
