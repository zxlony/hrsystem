package com.iotek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.ApplyDao;
import com.iotek.ssm.entity.Apply;
import com.iotek.ssm.service.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {
	
	@Autowired
	private ApplyDao applyDao;

	@Override
	public int addApply(Apply apply) {
		return applyDao.insertApply(apply);
	}

	@Override
	public List<Apply> findAllApply() {
		return applyDao.queryAllApply();
	}

	@Override
	public Apply findApplyByUname(String uname) {
		return applyDao.queryApplyByUname(uname);
	}

	@Override
	public int delApply(int aid) {
		return applyDao.deleteApply(aid);
	}

	@Override
	public int updateApply(Apply apply) {
		return applyDao.updateApply(apply);
	}

	@Override
	public Apply findApplyByAid(int aid) {
		return applyDao.queryApplyByAid(aid);
	}

	@Override
	public Apply findApplyByUnameAndInterviewStatus(String uname) {
		return applyDao.queryApplyByUnameAndInterviewStatus(uname);
	}

	@Override
	public List<Apply> findApplyByDidAndInterviewStatus(int did) {
		return applyDao.queryApplyByDidAndInterviewStatus(did);
	}

}
