package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Dept;

public interface DeptService {
	public List<Dept> findAllDept();
	
	public Dept findDeptByDname(String dname);
}
