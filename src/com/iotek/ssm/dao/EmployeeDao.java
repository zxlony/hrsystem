package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Employee;

public interface EmployeeDao {
	public Employee queryEmpByUid(int uid);
	
	public int insertEmployee(Employee emp);
	
	public int updateEmployee(Employee emp);

	public List<Employee> queryEmpByPid(int pid);
	
	public List<Employee> queryEmpByType(int type);

	public int updateEmpPidAndStation(Employee emp);
	
}
