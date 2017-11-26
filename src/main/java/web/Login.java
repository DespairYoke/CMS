package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.supperDao;
import entity.Count;
import entity.Supper;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	/*获得参数值*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=(String) request.getParameter("username");
		String pwd=(String) request.getParameter("pwd");
		System.out.println(uname+"  "+pwd);
		String radio=request.getParameter("admin");
		System.out.println(uname+"  "+pwd+"  "+radio);
		supperDao dao=new supperDao();
		Count count=dao.findCountByUname(uname);
		count.setUname(uname);
		count.setPassword(pwd);
		ServletContext sc=request.getServletContext();
		sc.setAttribute("count",count);
		List<Supper> list;
		
		list=dao.findsupper();
		for (Supper supper:list) {
			if(supper.getUname().equals(uname)&&supper.getPassword().equals(pwd))
			{
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
		}
		request.setAttribute("msg", "密码错误！");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
