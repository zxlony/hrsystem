package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Apply;

public interface ApplyService {
	public int addApply(Apply apply);

	public List<Apply> findAllApply();

	public Apply findApplyByUname(String uname);

	public int delApply(int aid);

	public int updateApply(Apply apply);

	public Apply findApplyByAid(int aid);

	public Apply findApplyByUnameAndInterviewStatus(String uname);

	public List<Apply> findApplyByInterviewStatus();
}
