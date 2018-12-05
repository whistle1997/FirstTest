package com.wsl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFatmet {
	public static Date getDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
}
