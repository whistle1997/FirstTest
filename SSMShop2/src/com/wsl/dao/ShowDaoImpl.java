package com.wsl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.wsl.bean.Show;
import com.wsl.util.C3p0GetUtil;

public class ShowDaoImpl implements ShowDao {

	@Override
	public List<Show> showAll() {
		String sql = "SELECT eid,ename,job,dpetno,dname,LOCAL,jointime FROM emp e LEFT JOIN dept d ON e.dpetno=d.Deptno";
		/*QueryRunner qr = new QueryRunner();
		
		try {
			List<Show> list = qr.query(sql, new BeanListHandler<Show>(Show.class));
			System.out.println(list);
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;*/
		
		Connection connection = null;
		try {
			connection = C3p0GetUtil.getDs().getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Show> list = new ArrayList<Show>();
			while(rs.next()) {
				Show show = new Show();
				show.setEid(rs.getInt("eid"));
				show.setEname(rs.getString("ename"));
				show.setJob(rs.getString("job"));
				show.setDpetno(rs.getInt("dpetno"));
				show.setDname(rs.getString("dname"));
				show.setLocal(rs.getString("Local"));
				show.setJointime(new java.util.Date(rs.getDate("jointime").getTime()));
				list.add(show);
				
			}
			for(Show s : list) {
				System.out.println(s);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
