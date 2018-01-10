package com.iotek.ssm.dao;

import com.iotek.ssm.entity.Employee;

public interface EmployeeDao {
	public Employee queryEmpByUid(int uid);
	
	public int insertEmployee(Employee emp);
	
	public int updateEmployee(Employee emp);
	
}
