package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.countDao;
import dao.rmsDao;
import entity.Count;
import entity.Rms;


public class mainWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
				
		String uname=(String) request.getParameter("username");
		System.out.println("uname:"+uname);
		countDao dao=new countDao();
		Count count=null;
		try{
			count=dao.findCountByUname(uname);
			request.setAttribute("count", count);
			request.getRequestDispatcher("main.jsp").forward(request, response);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}
		
		
		
	}

}
