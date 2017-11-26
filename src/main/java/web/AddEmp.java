package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.rmsDao;
import dao.supperDao;
import entity.Emp;
import entity.Rms;
import entity.Supper;


public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
		
		//编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		/*
		 * 先比较验证码是否正确，如果不正确，刷新验证码并提示用户，
		 */
		//用户提交的验证码
		String number1=request.getParameter("number");
		//session对象上事先绑定的验证码
		HttpSession session=request.getSession();
		String number2=(String)session.getAttribute("number");
		
		//比较两个验证码
		
		if(!number1.equalsIgnoreCase(number2)){
			System.out.println(111);
			//验证码不匹配，转发到注册页面，并提示用户
			request.setAttribute("number_error", "验证码不正确");
			request.getRequestDispatcher("addUser.jsp").forward(request, response);
			return;
		}
		
		
			String uname=request.getParameter("uname");
			//先查看用户名是否存在
			System.out.println("uname:"+uname);
			rmsDao dao=new rmsDao();
			try {
				Rms rms=null;
				List list=dao.findByUserName(uname);
				
				if(list!=null){//用户名已经存在，则提示用户
					request.setAttribute("regist_failed", "用户名已经存在");
					//获得转发器
					request.getRequestDispatcher("addUser.jsp").forward(request, response);
					
				}else{
					rms=new Rms();
					String name=request.getParameter("name");
					String password=request.getParameter("password");
					String department=request.getParameter("department");
					int age=Integer.parseInt(request.getParameter("age"));
					String gender=request.getParameter("gender");
					String registdate0=request.getParameter("registdate");
					double salary=Double.parseDouble(request.getParameter("salary"));
					Date registdate=Date.valueOf(registdate0);
					System.out.println("用户名："+uname+",真实姓名："+name+",密码："+
					     password+",年龄："+age+",性别："+gender+",注册时间:"+registdate);
					rms.setUname(uname);
					rms.setName(name);
					rms.setDepartment(department);
					rms.setAge(age);
					rms.setGender(gender);
					rms.setPassword(password);
					rms.setRegistDate(registdate);
					rms.setSalary(salary);
					dao.save(rms);
					out.println("<h1>添加新用户成功！</h1>");
			    }
			}catch(Exception e){
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
       
	}

}
