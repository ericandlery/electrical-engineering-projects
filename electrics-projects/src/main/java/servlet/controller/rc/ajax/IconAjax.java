package servlet.controller.rc.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.json.JacksonUtils;

@WebServlet(urlPatterns="/iconAjax.do")
public class IconAjax extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionType=req.getParameter("actionType");
		/*Get the icon list*/
		if("getIconList".equals(actionType)) {
			
			List<String> iconList=new ArrayList<>();
			URL iconFolderUrl=getServletContext().getResource("/resistor_circuit/images");
			
			try {
				File iconFolder=new File(iconFolderUrl.toURI());
				
				File[] icons=iconFolder.listFiles();
				for(File icon:icons) {
					iconList.add(icon.getName());
				}
				
				String icnoJson=JacksonUtils.listToJson(iconList);
				
				resp.setContentType("application/json;charset=UTF-8");
				PrintWriter out=resp.getWriter();
				out.print(icnoJson);
				out.flush();
				
				return;
			} catch (URISyntaxException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
			
		}else {
			throw new RuntimeException();
		}
	}

}
