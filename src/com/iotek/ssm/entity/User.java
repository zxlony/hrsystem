package com.iotek.ssm.entity;

public class User {
	private int uid;
	private String uname;
	private String password;
	private int type;
	public User() {
		super();
	}
	public User(int uid, String uname, String password, int type) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.type = type;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
