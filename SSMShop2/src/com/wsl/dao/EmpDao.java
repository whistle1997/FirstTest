package com.wsl.dao;

import com.wsl.bean.Emp;

public interface EmpDao {
	public boolean deleteOne(int id);
	
	public boolean updateOne(int id);
	
	public Emp getOne(int id);
	
	public boolean updateTrue(int id,String ename,String job,int dpet);
}
