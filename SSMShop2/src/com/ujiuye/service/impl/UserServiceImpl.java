package com.ujiuye.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.User;
import com.ujiuye.mapper.CartMapper;
import com.ujiuye.mapper.UserMapper;
import com.ujiuye.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private CartMapper cartMapper;
	
	@Override
	@Transactional
	public boolean reg(User user) {
		int userCount = userMapper.insert(user);
		Cart cart = new Cart();
		cart.setUid(user.getUid());
		cart.setCdis(user.getName()+"的购物车");
		int cartCount = cartMapper.insert(cart);
		if(userCount > 0 && cartCount > 0 ) {
			return true;
		}
		return false;
	}
	@Override
	public User getOneByName(String username) {
		// TODO Auto-generated method stub
		return userMapper.getOneByName(username);
	}

}
