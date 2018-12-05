package com.ujiuye.service;

import java.util.List;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Orders;

public interface OrdersService {
	public boolean addOrders(Orders orders , Cart car);
	
	public List<Orders> getOrdersByUid(int uid);
}
