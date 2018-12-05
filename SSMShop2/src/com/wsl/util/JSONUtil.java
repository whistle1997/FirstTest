package com.wsl.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class JSONUtil {
	public static void runJson(HttpServletRequest req, HttpServletResponse resp,Object obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		System.out.println(json);
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
