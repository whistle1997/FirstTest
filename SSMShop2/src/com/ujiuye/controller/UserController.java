package com.ujiuye.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujiuye.bean.User;
import com.ujiuye.service.UserService;
import com.ujiuye.util.TestBoolean;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("reg")
	public String reg(User user) {
		boolean reg = userService.reg(user);
		if(reg) {
			return "redirect:../login.jsp";
		}
		
		return null;
	}
	
	@RequestMapping("log")
	public String log(String username , String password , HttpServletRequest req , HttpServletResponse resp) {
		
		User user = userService.getOneByName(username);
		if(user != null) {
			if(password.equals(user.getPassword())) {
				req.getSession().setAttribute("activeuser", user);
				
			}else {
				return "redirect:../register.jsp";
			}
		}else {
			return "redirect:../register.jsp";
		}
		String rem = req.getParameter("rem");
		String autoLogin = req.getParameter("autoLogin");
		if("rem".equals(rem)) {				
			Cookie cookie = new Cookie("user", username+":"+password);
			cookie.setPath(req.getContextPath());
			cookie.setMaxAge(Integer.MAX_VALUE);
			resp.addCookie(cookie);
		}
		
		if("autoLogin".equals(autoLogin)) {				
			Cookie cookie = new Cookie("autoLogin", "true");
			cookie.setPath(req.getContextPath());
			cookie.setMaxAge(Integer.MAX_VALUE);
			resp.addCookie(cookie);
		}
		return "redirect:../index.jsp";
	}
	
	@RequestMapping("adminLogin")
	@ResponseBody
	public TestBoolean adminLogin(String username , String password) {
		TestBoolean tb = new TestBoolean();
		if("admin".equals(username) && "admin".equals(password)) {
			tb.setMassage("main");
			tb.setFlag(true);
		}
		
		return tb ;
	}
	@RequestMapping("userOut")
	public String userOut(HttpSession session) {
		session.removeAttribute("activeuser");
		return "redirect:../index.jsp"; 
	}
}
