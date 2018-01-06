package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Apply;

public interface ApplyDao {
	public int insertApply(Apply apply);
	
	public List<Apply> queryAllApply();
	
	public Apply queryApplyByUname(String uname);
	
	public int  deleteApply(int aid);
	
	public int updateApply(Apply apply);
}
