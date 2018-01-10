package com.iotek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.CheckonDao;
import com.iotek.ssm.entity.Checkon;
import com.iotek.ssm.service.CheckonService;

@Service("checkonService")
public class CheckonServiceImpl implements CheckonService {

	@Autowired
	private CheckonDao checkonDao;
	
	@Override
	public int addCheckon(Checkon checkon) {
		return checkonDao.insertCheckon(checkon);
	}

	@Override
	public List<Checkon> findCheckonByUid(int uid, String clockMonth) {
		return checkonDao.queryCheckonByUid(uid, clockMonth);
	}

	@Override
	public Checkon findByUidAndClock(int uid, String clockDate) {
		return checkonDao.queryByUidAndClock(uid, clockDate);
	}

	@Override
	public int updateCheckon(Checkon checkon) {
		return checkonDao.updateCheckon(checkon);
	}

}
