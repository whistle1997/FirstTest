package com.wsl.bean;

import java.util.Date;

public class Show {
	private int eid; //Ա�����
	private String ename;  //Ա������
	private String job;  //����
	private int dpetno; //���ű��
	private String dname; //��������
	private String Local;  //����λ��
	private Date jointime;  //��ְ����
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
