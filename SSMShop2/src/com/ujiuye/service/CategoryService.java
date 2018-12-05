package com.ujiuye.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ujiuye.bean.Category;
import com.ujiuye.mapper.CategoryMapper;


public interface CategoryService {
	
	public List<Category> getCategory();
}
