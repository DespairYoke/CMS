package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.rmsDao;
import util.DBUtil;

/**
 * Servlet implementation class UpdatePassword
 */
public class UpdatePassword extends HttpServlet {
       
	public void service(HttpServletRequest req,HttpServletResponse resp){
		resp.setContentType("text/html;charset=utf-8");
		String initpwd=req.getParameter("initpwd");
		String newpwd=req.getParameter("newpwd");
		ServletContext sc=req.getServletContext();
		System.out.println(initpwd);
		if(!initpwd.equals(sc.getAttribute("password")))
		{
			try {
				PrintWriter pw=resp.getWriter();
				pw.println("初始密码不对!请重新输入!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			rmsDao rms=new  rmsDao();
			try {
				rms.updatepassword(newpwd,(String)sc.getAttribute("name"));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				resp.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
