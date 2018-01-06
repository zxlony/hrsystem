package com.iotek.ssm.entity;

import java.util.Date;

public class Apply {
	private int aid;
	private String uname;
	private Date deliveryTime;
	private String checkStatus;
	private String interviewStatus;
	private Date interviewTime;
	private int hiring;

	public Apply() {
		super();
	}

	public Apply(int aid, String uname, Date deliveryTime, String checkStatus, String interviewStatus,
			Date interviewTime, int hiring) {
		super();
		this.aid = aid;
		this.uname = uname;
		this.deliveryTime = deliveryTime;
		this.checkStatus = checkStatus;
		this.interviewStatus = interviewStatus;
		this.interviewTime = interviewTime;
		this.hiring = hiring;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public Date getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}

	public int getHiring() {
		return hiring;
	}

	public void setHiring(int hiring) {
		this.hiring = hiring;
	}

	@Override
	public String toString() {
		return "Apply [aid=" + aid + ", uname=" + uname + ", deliveryTime=" + deliveryTime + ", checkStatus="
				+ checkStatus + ", interviewStatus=" + interviewStatus + ", interviewTime=" + interviewTime
				+ ", hiring=" + hiring + "]";
	}

}
