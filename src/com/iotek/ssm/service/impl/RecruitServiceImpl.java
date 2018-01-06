package com.iotek.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.RecruitDao;
import com.iotek.ssm.entity.Recruit;
import com.iotek.ssm.service.RecruitService;

@Service("recruitService")
public class RecruitServiceImpl implements RecruitService {

	@Autowired
	private RecruitDao recruitDao;
	
	@Override
	public List<Recruit> findAllRecruit() {
		return recruitDao.queryAllRecruit();
	}

	@Override
	public int addRecruit(Recruit recruit) {
		recruit.setPubdate(new Date());
		return recruitDao.insertRecruit(recruit);
	}

	@Override
	public int delRecruit(int rid) {
		return recruitDao.deleteRecruit(rid);
	}

	@Override
	public int updateRecruit(Recruit recruit) {
		return recruitDao.updateRecruit(recruit);
	}

	@Override
	public Recruit findRecruitByRid(int rid) {
		return recruitDao.queryRecruitByRid(rid);
	}

}
