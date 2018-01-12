package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Employee;

public interface EmpService {
	public Employee findEmpByUid(int uid);

	public int addEmployee(Employee emp);

	public int updateEmployee(Employee emp);

	public List<Employee> findEmpByPid(int pid);
	
	public List<Employee> findEmpByType(int type);
}
