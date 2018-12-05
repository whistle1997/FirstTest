package com.ujiuye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Cartitem;
import com.ujiuye.bean.CartitemExample;
import com.ujiuye.bean.CartitemExample.Criteria;
import com.ujiuye.bean.Orderitem;
import com.ujiuye.bean.Orders;
import com.ujiuye.bean.Product;
import com.ujiuye.mapper.CartitemMapper;
import com.ujiuye.mapper.OrderitemMapper;
import com.ujiuye.mapper.OrdersMapper;
import com.ujiuye.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Resource
	private OrdersMapper ordersMapper;
	@Resource
	private CartitemMapper cartitemMapper;
	@Resource
	private OrderitemMapper orderitemMapper;
	@Override
	@Transactional
	public boolean addOrders(Orders orders , Cart car) {
		int insert = ordersMapper.insert(orders);
		List<Cartitem> list = car.getCartitems();
		for(Cartitem ci : list) {
			Orderitem oit = new Orderitem();
			Product product = ci.getProduct();
			oit.setCount(ci.getCount());
			oit.setOid(orders.getOid());
			oit.setPid(ci.getCid());
			oit.setSubtotal(ci.getSubtotal());
			oit.setPid(product.getPid());
			orderitemMapper.insert(oit);
			
		}
		
		CartitemExample ex = new CartitemExample();
		Criteria cc = ex.createCriteria();
		cc.andCidEqualTo(car.getCid());
		int flag = cartitemMapper.deleteByExample(ex);
		return true;
	}
	@Override
	public List<Orders> getOrdersByUid(int uid) {
		// TODO Auto-generated method stub
		return ordersMapper.getOrdersByUid(uid);
	}

}
