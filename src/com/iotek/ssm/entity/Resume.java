package com.iotek.ssm.entity;

public class Resume {
	private int rid;
	private int uid;
	private String name;
	private String sex;
	private int age;
	private String education;
	private String phone;
	private String email;
	private String jobApplied;
	private String status;
	private String lastJob;
	private String experience;
	private String expectSalary;
	private String hobby;

	public Resume() {
		super();
	}

	public Resume(int rid, int uid, String name, String sex, int age, String education, String phone, String email,
			String jobApplied, String status, String lastJob, String experience, String expectSalary, String hobby) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.education = education;
		this.phone = phone;
		this.email = email;
		this.jobApplied = jobApplied;
		this.status = status;
		this.lastJob = lastJob;
		this.experience = experience;
		this.expectSalary = expectSalary;
		this.hobby = hobby;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getJobApplied() {
		return jobApplied;
	}

	public void setJobApplied(String jobApplied) {
		this.jobApplied = jobApplied;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastJob() {
		return lastJob;
	}

	public void setLastJob(String lastJob) {
		this.lastJob = lastJob;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getExpectSalary() {
		return expectSalary;
	}

	public void setExpectSalary(String expectSalary) {
		this.expectSalary = expectSalary;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
