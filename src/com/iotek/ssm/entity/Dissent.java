package com.iotek.ssm.entity;

public class Dissent {
	private int did;
	private int uid;
	private String ename;
	private String cause;
	private String month;

	public Dissent() {
		super();
	}

	public Dissent(int did, int uid, String ename, String cause, String month) {
		super();
		this.did = did;
		this.uid = uid;
		this.ename = ename;
		this.cause = cause;
		this.month = month;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Dissent [did=" + did + ", uid=" + uid + ", ename=" + ename + ", cause=" + cause + ", month=" + month
				+ "]";
	}

}
