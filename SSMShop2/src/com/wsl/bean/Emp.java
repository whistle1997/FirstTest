package com.wsl.bean;

import java.util.Date;

public class Emp {
	private int eid;
	private String ename;
	private String job;
	private int dpetno;
	private Date jointime;
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
	public Date getJointime() {
		return jointime;
	}
	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}
	
	
}
