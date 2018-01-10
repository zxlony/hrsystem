package com.iotek.ssm.entity;

import java.util.Date;

public class Employee {
	private int eid;
	private int uid;
	private int pid;
	private String ename;
	private String sex;
	private int age;
	private String education;
	private String phone;
	private String email;
	private String station;
	private String status;
	private Date hireDate;
	private String hobby;
	private int type;

	public Employee() {
		super();
	}

	public Employee(int eid, int uid, int pid, String ename, String sex, int age, String education, String phone,
			String email, String station, String status, Date hireDate, String hobby, int type) {
		super();
		this.eid = eid;
		this.uid = uid;
		this.pid = pid;
		this.ename = ename;
		this.sex = sex;
		this.age = age;
		this.education = education;
		this.phone = phone;
		this.email = email;
		this.station = station;
		this.status = status;
		this.hireDate = hireDate;
		this.hobby = hobby;
		this.type = type;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", uid=" + uid + ", pid=" + pid + ", ename=" + ename + ", sex=" + sex + ", age="
				+ age + ", education=" + education + ", phone=" + phone + ", email=" + email + ", station=" + station
				+ ", status=" + status + ", hireDate=" + hireDate + ", hobby=" + hobby + ", type=" + type + "]";
	}

}
