package com.iotek.ssm.service;

import com.iotek.ssm.entity.Employee;

public interface EmpService {
	public Employee findEmpByUid(int uid);

	public int addEmployee(Employee emp);

	public int updateEmployee(Employee emp);
}
