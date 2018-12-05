package com.ujiuye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ujiuye.bean.Category;
import com.ujiuye.mapper.CategoryMapper;
import com.ujiuye.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryMapper categoryMapper;
	
	
	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.selectByExample(null);
	}

}
