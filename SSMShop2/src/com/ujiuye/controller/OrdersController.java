package com.ujiuye.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Orders;
import com.ujiuye.bean.User;
import com.ujiuye.service.OrdersService;
import com.ujiuye.util.IDUtil;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Resource
	private OrdersService ordersService;
	
	@RequestMapping("addOrders")
	public String addOrders(Orders orders,HttpSession session) {
		User user = (User)session.getAttribute("activeuser");
		//orders.setOid(IDUtil.getID());
		orders.setOrdertime(new java.util.Date());
		orders.setUid(user.getUid());
		Cart car = (Cart)session.getAttribute("cart");
		ordersService.addOrders(orders, car);
		return "redirect:/index.jsp";
	}
	@RequestMapping("showOrders")
	public String showOrders(HttpSession session) {
		User user = (User)session.getAttribute("activeuser");
		if(user == null) {
			return "redirect:/login.jsp";
		}
		List<Orders> list = ordersService.getOrdersByUid(user.getUid());
		session.setAttribute("myorder", list);
		return "redirect:/order_list.jsp";
	}
}
