package com.ujiuye.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Cartitem;
import com.ujiuye.bean.Product;
import com.ujiuye.bean.User;
import com.ujiuye.service.CartService;
import com.ujiuye.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Resource
	private CartService cartService;
	private ProductService productService;
	@RequestMapping("addCartitem")
	public String addCartitem(Cartitem ci , double price , HttpSession session) {
		User user = (User)session.getAttribute("activeuser");
		if(user == null) {
			return "redirect:/login.jsp";
		}
		
		Cart car = cartService.getOneCarByUid(user.getUid());
		double subtotal = ci.getCount()*price;
		ci.setSubtotal(subtotal);
		ci.setCid(car.getCid());
		cartService.addCartitem(ci);
		
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("showCart")
	public String showCart(HttpSession session) {
		User user = (User)session.getAttribute("activeuser");
		if(user == null) {
			return "redirect:/login.jsp";
		}
		
		Cart car = cartService.getOneCarByUid(user.getUid());
		session.setAttribute("cart", car);
		return "redirect:/cart.jsp";
	}
	
	@RequestMapping("deleteCart")
	public String deleteCart(Integer[] ids) {
		System.out.println(ids);
		boolean flag = cartService.deleteCaritem(ids);
		if(flag) {
			return "redirect:showCart";
		}
		return "redirect:/index.jsp";
	}
	
	
	@RequestMapping("deleteOne")
	public String deleteOne(int id) {
		boolean flag = cartService.deleteOne(id);
		if(flag) {
			return "redirect:showCart";
		}
		return "redirect:/index.jsp";
	}
	
}
