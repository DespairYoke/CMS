package web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.messageDao;
import entity.Count;
import entity.Message;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import sun.print.resources.serviceui;

public class Message_add extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Message msg=new Message();
		req.setCharacterEncoding("utf-8");
		ServletContext sc=req.getServletContext();
		Count count= (Count) sc.getAttribute("count");
		System.out.println(count.getUname());
		msg.setUname(count.getUname());
		msg.setContent(req.getParameter("content"));
		msg.setEmail(req.getParameter("email"));
		msg.setTitle(req.getParameter("title"));
		msg.setMestime(new Date(System.currentTimeMillis()));
		System.out.println(msg);
		messageDao msgdao = null;
		try {
			msgdao = new messageDao();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			msgdao.addMsg(msg);
			req.getRequestDispatcher("main_message.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
