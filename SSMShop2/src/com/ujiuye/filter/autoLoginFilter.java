package com.ujiuye.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ujiuye.bean.User;
import com.ujiuye.service.UserService;

@Component
@WebFilter(urlPatterns= {"/login.jsp"})
public class autoLoginFilter implements Filter {
    
	@Autowired
	private UserService  userService ;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		//如果被选中，则创建一个cookie以方便下次保存自动登录
		Cookie[] cks = request.getCookies();
		String username = null;
		String password = null;
		for(Cookie ck : cks) {
			
			if("user".equals(ck.getName())) {
				
				String[] str = ck.getValue().split(":");
				username = str[0];
				password = str[1];
			}
			if("autoLogin".equals(ck.getName())) {
				System.out.println("=========================");
				User user = userService.getOneByName(username);
				System.out.println("=================================&&&&&&&&&&&&&&&&&"+user.getName());
				request.getSession().setAttribute("activeuser", user);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;
			}
		}
		
		arg2.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
