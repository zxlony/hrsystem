package com.iotek.ssm.entity;

import java.util.Date;

public class Train {
	private int tid;
	private String tname;
	private Date time;
	private Dept dept;

	public Train() {
		super();
	}

	public Train(int tid, String tname, Date time, Dept dept) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.time = time;
		this.dept = dept;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Train [tid=" + tid + ", tname=" + tname + ", time=" + time + ", dept=" + dept + "]";
	}

}
