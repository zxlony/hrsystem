package com.iotek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.CheckonDao;
import com.iotek.ssm.dao.EmployeeDao;
import com.iotek.ssm.entity.Checkon;
import com.iotek.ssm.entity.CheckonRecord;
import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.service.CheckonService;

@Service("checkonService")
public class CheckonServiceImpl implements CheckonService {

	@Autowired
	private CheckonDao checkonDao;
	@Autowired
	private EmployeeDao empDao;
	
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

	/**
	 * 获得员工的基本工资
	 * 员工职位是总监，基本工资1000一天，其余同理
	 */
	@Override
	public double getBase(int uid, String clockMonth) {
		List<Checkon> checkons = checkonDao.queryCheckonByUid(uid, clockMonth);
		int workDays =  checkons.size();
		Employee emp = empDao.queryEmpByUid(uid);
		if(emp.getStation().contains("总监")) {
			return 1000*workDays;
		}
		if(emp.getStation().contains("主管")) {
			return 800*workDays;
		}
		if(emp.getStation().contains("经理")) {
			return 500*workDays;
		}
		return 300*workDays;
	}

	@Override
	public CheckonRecord getRecord(int uid, String clockMonth) {
		List<Checkon> checkons = checkonDao.queryCheckonByUid(uid, clockMonth);
		int absence = 21-checkons.size();
		int miner = checkonDao.getStatusCount(uid, "矿工");
		int late = checkonDao.getStatusCount(uid, "迟到");
		int leave = checkonDao.getStatusCount(uid, "早退");
		int lateAndLeave = checkonDao.getStatusCount(uid, "迟到且早退");
		return new CheckonRecord(absence, miner, late, leave, lateAndLeave);
	}

}
