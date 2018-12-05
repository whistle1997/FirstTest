package com.ujiuye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ujiuye.bean.ProCatKey;
import com.ujiuye.bean.Product;
import com.ujiuye.mapper.ProCatMapper;
import com.ujiuye.mapper.ProductMapper;
import com.ujiuye.service.ProductService;

@Service  //声明这是一个service
public class ProductServiceImpl implements ProductService {
	
	@Resource
	private ProductMapper productMapper;
	@Resource
	private ProCatMapper proCatMapper;
	@Override
	public List<Product> hotList() {
		return productMapper.getHot();
		
	}

	@Override
	public List<Product> newList() {
		// TODO Auto-generated method stub
		return productMapper.getNew();
	}

	@Override
	public List<Product> showList(int cid) {
		
		List<Product> page = productMapper.showPage(cid);
		return page;
	}

	@Override
	public Product getOne(int pid) {
		
		return productMapper.getOne(pid);
	}

	@Override
	public List<Product> sreachPrso(String sreachinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sreachPro(String sreachinfo) {
		// TODO Auto-generated method stub
		return productMapper.sreachPro(sreachinfo);
	}

	@Override
	public List<Product> limitProList(int page, int rows) {
		// TODO Auto-generated method stub
		int start = (page-1)*rows;
		return productMapper.limitProList(start, rows);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return productMapper.getCount();
	}

	@Override
	public boolean addProduct(Product pro , int cid) {
		int insert = productMapper.insert(pro);
		ProCatKey record = new ProCatKey();
		record.setCid(cid);
		record.setPid(pro.getPid());
		System.out.println(record.getPid() + "++++++++" + record.getCid() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		int insert2 = proCatMapper.insert(record);
		if(insert > 0 && insert2 > 0) {
			return true;
		}
		return false;
	}


	

}
