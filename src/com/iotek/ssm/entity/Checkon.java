package com.iotek.ssm.entity;

import java.util.Date;

public class Checkon {
	private int cid;
	private int uid;
	private String ename;
	private String clockDate;
	private Date startTime;
	private Date endTime;
	private String status; // ³öÇÚ×´¿ö

	public Checkon() {
		super();
	}

	public Checkon(int cid, int uid, String ename, String clockDate, Date startTime, Date endTime, String status) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.ename = ename;
		this.clockDate = clockDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public String getClockDate() {
		return clockDate;
	}

	public void setClockDate(String clockDate) {
		this.clockDate = clockDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Checkon [cid=" + cid + ", uid=" + uid + ", ename=" + ename + ", clockDate=" + clockDate + ", startTime="
				+ startTime + ", endTime=" + endTime + ", status=" + status + "]";
	}

}
