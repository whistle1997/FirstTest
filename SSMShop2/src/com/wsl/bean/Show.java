package com.wsl.bean;

import java.util.Date;

public class Show {
	private int eid; //员工编号
	private String ename;  //员工姓名
	private String job;  //工作
	private int dpetno; //部门编号
	private String dname; //部门名称
	private String Local;  //部门位置
	private Date jointime;  //入职日期
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getDpetno() {
		return dpetno;
	}
	public void setDpetno(int dpetno) {
		this.dpetno = dpetno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}
	public Date getJointime() {
		return jointime;
	}
	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}
	
	
}
