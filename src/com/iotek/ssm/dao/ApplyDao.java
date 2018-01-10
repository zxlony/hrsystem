package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Apply;

public interface ApplyDao {
	public int insertApply(Apply apply);
	
	public List<Apply> queryAllApply();
	
	public Apply queryApplyByUname(String uname);
	
	public int  deleteApply(int aid);
	
	public int updateApply(Apply apply);

	public Apply queryApplyByAid(int aid);

	public Apply queryApplyByUnameAndInterviewStatus(String uname);

	public List<Apply> queryApplyByDidAndInterviewStatus(int did);
}
