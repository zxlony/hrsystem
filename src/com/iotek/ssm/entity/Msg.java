package com.iotek.ssm.entity;

public class Msg {
	private int mid;
	private int uid;
	private String msg;

	public Msg() {
		super();
	}

	public Msg(int mid, int uid, String msg) {
		super();
		this.mid = mid;
		this.uid = uid;
		this.msg = msg;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Msg [mid=" + mid + ", uid=" + uid + ", msg=" + msg + "]";
	}

}
