package com.ujiuye.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Cartitem;
import com.ujiuye.bean.CartitemExample;
import com.ujiuye.bean.CartitemExample.Criteria;
import com.ujiuye.mapper.CartMapper;
import com.ujiuye.mapper.CartitemMapper;
import com.ujiuye.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Resource
	private CartitemMapper cartitemMapper;
	@Resource
	private CartMapper cartMapper;
	@Override
	public boolean addCartitem(Cartitem ci) {
		// TODO Auto-generated method stub
		 int i = cartitemMapper.insert(ci);
		 if(i > 0) {
			 return true;
		 }
		 return false;
	}

	@Override
	public Cart getOneCarByUid(int uid) {
		// TODO Auto-generated method stub
		return cartMapper.getOneCarByUid(uid);
	}

	@Override
	public boolean deleteCaritem(Integer[] ids) {
		CartitemExample ce = new CartitemExample();
		Criteria cc = ce.createCriteria();
		List<Integer> asList = Arrays.asList(ids);
		cc.andIdIn(asList);
		int count = cartitemMapper.deleteByExample(ce);
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteOne(int id) {
		int key = cartitemMapper.deleteByPrimaryKey(id);
		if(key>0) {
			return true;
		}
		return false;
	}
	

}
