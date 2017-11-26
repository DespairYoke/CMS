package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        System.out.println("CheckcodeServlet's service()");
        
        
        //生成图片
        /*
         *1.绘图
         */
        //先创建一个画布(内存映像对象)
        BufferedImage image=new BufferedImage(100, 25, 
        		BufferedImage.TYPE_INT_RGB);
        //获得画笔
        Graphics g=image.createGraphics();
        //给画笔设置颜色(涂画布)
        g.setColor(new Color(255,255,255));
        //给画布设置背景颜色
        g.fillRect(0, 0, 100, 30);
        
      //给画笔设置颜色
        Random r=new Random();
        g.setColor(new Color(r.nextInt(255),
        		r.nextInt(255), r.nextInt(255)));
   
        //设置字体（字体，风格，大小）
        g.setFont(new Font(null, Font.BOLD, 24));
        
        //在画布上绘图
        String number = getNumber(5);
        
        HttpSession session=request.getSession();
        session.setAttribute("number", number);
        //将验证码绑定到session对象上
        
        
        
        
        System.out.println("number:"+number);
        g.drawString(number, 5, 25);
        
        //加一些干扰线
        for (int i = 0; i < 8; i++) {
        	 g.setColor(new Color(r.nextInt(255),
             		r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
		}
        
        /*2.将图片压缩，然后输出，发送给浏览器
         * 
         */
        //设置content-type
        response.setContentType("image/jepg");
        //获得字节输出流（图片是二进制数据）
        OutputStream os=response.getOutputStream();
        //将原始图片（image）按照指定的算法压缩（jpeg）,
        //然后将压缩之后得到的字节写入response对象。
        
        javax.imageio.ImageIO.write(image, "jpeg", os);
        os.close();

	}
	/*
	 * 生成一个长度固定为size个字符，并且这些字符要求从
		(A~Z,0~9)中随机选取，比如 X09BD
	 */
	private String getNumber(int size) {
		Random r = new Random();
		String number = "";
		String chars = "ABCDEFGHIJKLMNOPQRS"
				+ "TUVWXYZ0123456789";
		for(int i = 0; i < size; i ++){
			number += chars.charAt(
					r.nextInt(chars.length()));
		}
		return number;
	}
	

}
