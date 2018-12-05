package com.wsl.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsl.bean.Emp;
import com.wsl.bean.Show;
import com.wsl.dao.EmpDao;
import com.wsl.dao.EmpDaoImpl;
import com.wsl.dao.ShowDao;
import com.wsl.dao.ShowDaoImpl;
import com.wsl.util.JSONUtil;
import com.wsl.util.TestBoolean;

@WebServlet("/servlet/RunServlet")
public class RunServlet extends HttpServlet {
	ShowDao sd = new ShowDaoImpl();
	EmpDao ed = new EmpDaoImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		String function = req.getParameter("method");
		System.out.println(function);
		try {
			Class<?> clazz = Class.forName("com.wsl.servlet.RunServlet");
			Method method = clazz.getMethod(function,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(clazz.newInstance(),req,resp);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void showInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		List<Show> list = sd.showAll();
		if(list.size() > 0) {
			JSONUtil.runJson(req, resp, list);
		}else {
			JSONUtil.runJson(req, resp, "暂无数据");
		}
	}
	
	
	public void deleteOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		boolean flag = ed.deleteOne(id);
		TestBoolean tb = new TestBoolean();
		if(flag) {
			tb.setFlag(true);
			tb.setMassage("删除成功");
		}else {
			tb.setFlag(false);
			tb.setMassage("删除失败");
		}
		JSONUtil.runJson(req, resp, tb);
	}
	
	public void updateOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		
		Emp one = ed.getOne(id);
		req.setAttribute("emp", one);
		JSONUtil.runJson(req, resp, one);
	}
	
	
	public void updateTrue(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		System.out.println("========================");
		int  eid = Integer.parseInt(req.getParameter("eid"));
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		int dpet = Integer.parseInt(req.getParameter("dpet"));
	
		boolean flag = ed.updateTrue(eid, ename, job, dpet);
		TestBoolean tb = new TestBoolean();
		if(flag) {
			tb.setFlag(true);
			tb.setMassage("修改成功");
		}else {
			tb.setFlag(false);
			tb.setMassage("修改失败");
		}
		JSONUtil.runJson(req, resp, tb);
	}
}
