package com.wsl.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//设置响应类型
			resp.setContentType("image/jpeg;charset=UTF-8"); 
			//创建一个图片缓冲区
			BufferedImage bi = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);
			
			Graphics gp = bi.getGraphics();
			
			gp.setColor(Color.CYAN);
			gp.fillRect(0, 0, 100 , 25);
			
			gp.setColor(Color.blue);
			gp.drawRect(0, 0, 100-1, 25-1);
			
			String str = "dsjfirkajdfkhjfkajfigdsfhkg";
			String code="";
			for(int i = 0 ; i< 4 ; i++) {
				code += str.charAt(new Random().nextInt(str.length()));
			}
			
			System.out.println(code);
			req.getSession().setAttribute("code", code);
			gp.setFont(new Font("隶书",Font.BOLD,20));
			gp.drawString(code, 20, 20);
			
			resp.setContentType("image/jpeg;charset=UTF-8");
			ImageIO.write(bi, "jpg", resp.getOutputStream());
		}
}
