package com.iotek.ssm.entity;


public class Rewandpun {
	public int rid;
	public int uid;
	public String ename;
	public String cause;
	public String rptime;
	public double money;
	public String type;

	public Rewandpun() {
		super();
	}

	public Rewandpun(int rid, int uid, String ename, String cause, String rptime, double money, String type) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.ename = ename;
		this.cause = cause;
		this.rptime = rptime;
		this.money = money;
		this.type = type;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getRptime() {
		return rptime;
	}

	public void setRptime(String rptime) {
		this.rptime = rptime;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Rewandpun [rid=" + rid + ", uid=" + uid + ", ename=" + ename + ", cause=" + cause + ", rptime=" + rptime
				+ ", money=" + money + ", type=" + type + "]";
	}

}
