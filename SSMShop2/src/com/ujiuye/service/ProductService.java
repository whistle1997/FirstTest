package com.ujiuye.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ujiuye.bean.Product;

public interface ProductService {
	
	public List<Product> hotList();
	
	public List<Product> newList();
	
	public List<Product> showList(int cid);
	
	public Product getOne(int pid);
	
	public List<Product> sreachPrso(String sreachinfo);

	List<Product> sreachPro(String sreachinfo);
	
	List<Product> limitProList(int page , int rows);
	
	int getCount();
	
	boolean addProduct(Product pro , int cid);
}
