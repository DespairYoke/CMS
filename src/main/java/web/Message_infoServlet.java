package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.messageDao;
import entity.Message;

/**
 * Servlet implementation class Message_infoServlet
 */
public class Message_infoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
	
		messageDao dao = new messageDao();
		PrintWriter out = response.getWriter();
	
			int id = Integer.valueOf((request.getParameter("id")));
			System.out.println("id:"+id);
			try {
		Message m =dao.findById(id);
				
				request.setAttribute("info",m);
				request.getRequestDispatcher("message_info.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<h1>系统繁忙</h1>");
				
			}
	}

}
