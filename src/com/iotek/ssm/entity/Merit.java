package com.iotek.ssm.entity;

public class Merit {
	private int mid;
	private int uid;
	private String ename;
	private double bonus;
	private String month;

	public Merit() {
		super();
	}

	public Merit(int mid, int uid, String ename, double bonus, String month) {
		super();
		this.mid = mid;
		this.uid = uid;
		this.ename = ename;
		this.bonus = bonus;
		this.month = month;
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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Merit [mid=" + mid + ", uid=" + uid + ", ename=" + ename + ", bonus=" + bonus + ", month=" + month
				+ "]";
	}

}
