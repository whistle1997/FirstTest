package com.wsl.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3p0GetUtil {
	static ComboPooledDataSource ds = null ;
	static {
		ds = new ComboPooledDataSource();
	}
	
    public static DataSource getDs(){
        
        return ds;
    }



}
