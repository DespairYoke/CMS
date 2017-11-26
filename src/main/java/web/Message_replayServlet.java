package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.messageDao;
import entity.Message;

/**
 * Servlet implementation class Message_replayServlet
 */
public class Message_replayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		messageDao dao = new messageDao();
		int i = Integer.valueOf(request.getParameter("id"));
		try {
			Message m = dao.findById(i);
			request.setAttribute("message", m);
			request.getRequestDispatcher("message_replay.jsp").forward(request, response);
		} catch (Exception e) {
			
		}
	}

}
