package com.iotek.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.EmployeeDao;
import com.iotek.ssm.entity.Employee;
import com.iotek.ssm.service.EmpService;

@Service("empService")
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmployeeDao empDao;

	@Override
	public Employee findEmpByUid(int uid) {
		return empDao.queryEmpByUid(uid);
	}

	@Override
	public int addEmployee(Employee emp) {
		return empDao.insertEmployee(emp);
	}

	@Override
	public int updateEmployee(Employee emp) {
		return empDao.updateEmployee(emp);
	}

}
