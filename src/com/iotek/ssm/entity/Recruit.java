package com.iotek.ssm.entity;

import java.util.Date;

public class Recruit {
	private int rid;
	private String job;
	private String describe;
	private String address;
	private Date pubdate;

	public Recruit() {
	}

	public Recruit(int rid, String job, String describe, String address, Date pubdate) {
		super();
		this.rid = rid;
		this.job = job;
		this.describe = describe;
		this.address = address;
		this.pubdate = pubdate;
	}

	public int getrid() {
		return rid;
	}

	public void setrid(int rid) {
		this.rid = rid;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	@Override
	public String toString() {
		return "Recruit [rid=" + rid + ", job=" + job + ", describe=" + describe + ", address=" + address + ", pubdate="
				+ pubdate + "]";
	}

}
