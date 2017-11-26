package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.messageDao;

/**
 * Servlet implementation class delectServlet
 */
public class delectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;utf-8");
		request.setCharacterEncoding("utf-8");
		
		messageDao dao = new messageDao();
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf((request.getParameter("id")));
		
		try {
			dao.delect(id);
			response.sendRedirect("main_message.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h1>系统繁忙</h1>");
			
		}
	}

}
