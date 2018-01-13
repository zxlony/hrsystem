package com.iotek.ssm.entity;

/**
 * 对员工一个月内出勤状态的统计
 */
public class CheckonRecord {
	private int absence;	//缺勤天数
	private int miner; //矿工次数
	private int late;	//迟到次数
	private int leave;	//早退次数
	private int lateAndLeave;	//迟到且早退次数

	public CheckonRecord() {
		super();
	}

	public CheckonRecord(int absence, int miner, int late, int leave, int lateAndLeave) {
		super();
		this.absence = absence;
		this.miner = miner;
		this.late = late;
		this.leave = leave;
		this.lateAndLeave = lateAndLeave;
	}

	public int getAbsence() {
		return absence;
	}

	public void setAbsence(int absence) {
		this.absence = absence;
	}

	public int getMiner() {
		return miner;
	}

	public void setMiner(int miner) {
		this.miner = miner;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getLeave() {
		return leave;
	}

	public void setLeave(int leave) {
		this.leave = leave;
	}

	public int getLateAndLeave() {
		return lateAndLeave;
	}

	public void setLateAndLeave(int lateAndLeave) {
		this.lateAndLeave = lateAndLeave;
	}

	@Override
	public String toString() {
		return "CheckonRecord [absence=" + absence + ", miner=" + miner + ", late=" + late + ", leave=" + leave
				+ ", lateAndLeave=" + lateAndLeave + "]";
	}

}
