package com.iotek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.RewandpunDao;
import com.iotek.ssm.entity.Rewandpun;
import com.iotek.ssm.service.RewandpunService;

@Service("rewandpunService")
public class RewandpunServiceImpl implements RewandpunService {

	@Autowired
	private RewandpunDao rapDao;
	
	@Override
	public List<Rewandpun> findRapByRptime(String rptime) {
		return rapDao.queryRapByRptime(rptime);
	}

	@Override
	public List<Rewandpun> findRapByRptimeAndUid(String rptime, int uid) {
		return rapDao.queryRapByRptimeAndUid(rptime, uid);
	}

	@Override
	public int addRap(Rewandpun rap) {
		return rapDao.insertRap(rap);
	}

}
