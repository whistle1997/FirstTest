package com.ujiuye.service;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Cartitem;

public interface CartService {

	public boolean addCartitem(Cartitem ci);
	
	public Cart getOneCarByUid(int uid);
	
	public boolean deleteCaritem(Integer[] ids);
	
	public boolean deleteOne(int id);
}
