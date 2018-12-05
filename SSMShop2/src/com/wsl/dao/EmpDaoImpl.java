package com.wsl.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wsl.bean.Emp;
import com.wsl.util.C3p0GetUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public boolean deleteOne(int id) {
		String sql = "delete from emp where eid=?";
		QueryRunner qr = new QueryRunner(C3p0GetUtil.getDs());
		
		try {
			int i = qr.update(sql,id);
			if(i > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateOne(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Emp getOne(int id) {
		String sql = "select * from emp where eid="+id;
		QueryRunner qr = new QueryRunner(C3p0GetUtil.getDs());
		
		try {
			Emp emp = qr.query(sql, new BeanHandler<Emp>(Emp.class));
			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateTrue(int id, String ename, String job, int dpet) {
		String sql = "update emp set ename=?,job=?,dpetno=? where eid=?";
		QueryRunner qr = new QueryRunner(C3p0GetUtil.getDs());
		
		try {
			int i =qr.update(sql, ename,job,dpet,id);
			if(i > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
