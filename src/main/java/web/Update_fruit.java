package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.fruitDao;
import entity.Fruit;

public class Update_fruit extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//分析请求路径
		String uri=req.getRequestURI();
		//拆解路径
		String action=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("Action:"+action);
		if(action.equals("/update_fruit")){
			System.out.println("update_fruit");
			fruitDao dao=new fruitDao();
			Fruit e=new Fruit();
			System.out.println(req.getParameter("name"));
		e=dao.findByName(req.getParameter("name"));
		req.setAttribute("fruit", e);
		req.getRequestDispatcher("update_fruit.jsp").forward(req, resp);
		System.out.println("111");
		}
		else if(action.equals("/update_fruitinfo"))
				{
			System.out.println("hh");
			Fruit f=new Fruit();
		req.setCharacterEncoding("utf-8");
		f.setName(req.getParameter("name"));
		f.setPrice(Double.parseDouble(req.getParameter("price")));
		f.setSellprice(Double.parseDouble(req.getParameter("sellprice")));
		f.setNum(Integer.parseInt(req.getParameter("num")));
		f.setAdmin_name(req.getParameter("admin_name"));
		fruitDao dao=new fruitDao();
		dao.update_fruit(f);
		req.getRequestDispatcher("fruit_info.jsp").forward(req, resp);
		System.out.println("furfff");
				}
	}
}
