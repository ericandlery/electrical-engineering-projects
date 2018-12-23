package servlet.controller.rc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/rcCircuit")
public class PreRCServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*Height and Width*/
		int height=0;
		int width=0;
		try {
			height=Integer.parseInt(req.getParameter("height"));
			width=Integer.parseInt(req.getParameter("width"));
		}catch(NumberFormatException e) {
			/*Record these messages with Logging API if available.*/
			System.out.println(this.getClass().getName()+": NumberFormatException, check if it's debug mode.");
//			throw new NumberFormatException();
		}
		
		/*test*/
		req.setAttribute("height",4);
		req.setAttribute("width",7);
		
		/*prod*/
//		req.setAttribute("height",height);
//		req.setAttribute("width",width);
		
		req.getRequestDispatcher("/resistor_circuit/rc_main.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
