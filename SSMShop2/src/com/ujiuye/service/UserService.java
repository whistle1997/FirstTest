package com.ujiuye.service;

import com.ujiuye.bean.User;

public interface UserService {
	
	public boolean reg(User user);
	
	public User getOneByName(String username);
}
