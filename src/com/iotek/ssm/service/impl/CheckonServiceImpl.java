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
	 * ���Ա���Ļ�������
	 * Ա��ְλ���ܼ࣬��������1000һ�죬����ͬ��
	 */
	@Override
	public double getBase(int uid, String clockMonth) {
		List<Checkon> checkons = checkonDao.queryCheckonByUid(uid, clockMonth);
		int workDays =  checkons.size();
		Employee emp = empDao.queryEmpByUid(uid);
		if(emp.getStation().contains("�ܼ�")) {
			return 1000*workDays;
		}
		if(emp.getStation().contains("����")) {
			return 800*workDays;
		}
		if(emp.getStation().contains("����")) {
			return 500*workDays;
		}
		return 300*workDays;
	}

	@Override
	public CheckonRecord getRecord(int uid, String clockMonth) {
		List<Checkon> checkons = checkonDao.queryCheckonByUid(uid, clockMonth);
		int absence = 21-checkons.size();
		int miner = checkonDao.getStatusCount(uid, "��");
		int late = checkonDao.getStatusCount(uid, "�ٵ�");
		int leave = checkonDao.getStatusCount(uid, "����");
		int lateAndLeave = checkonDao.getStatusCount(uid, "�ٵ�������");
		return new CheckonRecord(absence, miner, late, leave, lateAndLeave);
	}

}
