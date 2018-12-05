package com.ujiuye.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.bean.Product;
import com.ujiuye.service.ProductService;

@Controller
@RequestMapping("/product") //设置访问路径名，防止同名的方法访问有误。
public class ProductController {
	
	@Resource
	private ProductService productService;
	
	@RequestMapping("showindex")
	@ResponseBody
	public Map<String,List<Product>> showindex(){
		Map<String,List<Product>> map = new HashMap<>();
		map.put("hotList", productService.hotList());
		map.put("newList", productService.newList());
		return map;
	}
	
	@RequestMapping("showList")
	public String showList(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,Integer cid,HttpSession session) {
		PageHelper.startPage(pn,6);
		List<Product> list = productService.showList(cid);
		PageInfo<Product> pageInfo = new PageInfo<>(list,6);
		session.setAttribute("prolist", pageInfo);
		session.setAttribute("cid", cid);
		return "redirect:/product_list.jsp";
	
	}
	
	@RequestMapping("getOne")
	public String getOne(int pid, HttpServletRequest req , HttpServletResponse resp) {
		Product one = productService.getOne(pid);
		req.getSession().setAttribute("one", one);
		return "redirect:/product_info.jsp";
	}
	
	@RequestMapping("sreachPro")
	public String sreachPro(String searchinfo,@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,HttpSession session){
		PageHelper.startPage(pn,6);
		List<Product> list = productService.sreachPro(searchinfo);
		PageInfo<Product> pageInfo = new PageInfo<>(list,6);
		session.setAttribute("prolist", pageInfo);
		//session.setAttribute("searchinfo", searchinfo);
		return "redirect:/product_list.jsp";
	}
	
	@RequestMapping("productList")
	@ResponseBody
	public Map<String,Object> productList(int rows , int page){
		 List<Product> proList = productService.limitProList(page, rows);
		 int total = productService.getCount();
		 Map<String,Object> map = new HashMap<String,Object>();
			map.put("rows",proList);
			map.put("total",total);
		 return map;
	}
	
	@RequestMapping("addProduct")
	@Transactional
	public String addProduct(MultipartFile pfile , Product pro ,int cid ) {
	
		String filename="";
		if(pfile.getSize() > 0) {
			String path = "D:\\myPic\\products\\1\\";
			filename = pfile.getOriginalFilename();
			File f = new File(path + filename);
			
			try {
				pfile.transferTo(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		pro.setPimage("products/1/"+filename);
		pro.setPdate(new java.util.Date());
		boolean flag = productService.addProduct(pro, cid);
		if(flag) {
			return "redirect:../admin/main.jsp";
		}
		return "";
	}
}
