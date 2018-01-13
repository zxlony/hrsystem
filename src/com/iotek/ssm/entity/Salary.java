package com.iotek.ssm.entity;

public class Salary {
	private int sid;
	private int uid;
	private String ename;
	private String month;
	private double base;
	private double merit;
	private double overtime;
	private double rewandpun;
	private double security;

	public Salary() {
		super();
	}

	public Salary(int sid, int uid, String ename, String month, double base, double merit, double overtime,
			double rewandpun, double security) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.ename = ename;
		this.month = month;
		this.base = base;
		this.merit = merit;
		this.overtime = overtime;
		this.rewandpun = rewandpun;
		this.security = security;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getMerit() {
		return merit;
	}

	public void setMerit(double merit) {
		this.merit = merit;
	}

	public double getOvertime() {
		return overtime;
	}

	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}

	public double getRewandpun() {
		return rewandpun;
	}

	public void setRewandpun(double rewandpun) {
		this.rewandpun = rewandpun;
	}

	public double getSecurity() {
		return security;
	}

	public void setSecurity(double security) {
		this.security = security;
	}
	
	public double getTotal() {
		return base+merit+overtime+rewandpun+security;
	}

	@Override
	public String toString() {
		return "Salary [sid=" + sid + ", uid=" + uid + ", ename=" + ename + ", month=" + month + ", base=" + base
				+ ", merit=" + merit + ", overtime=" + overtime + ", rewandpun=" + rewandpun + ", security=" + security
				+ "]";
	}

}
