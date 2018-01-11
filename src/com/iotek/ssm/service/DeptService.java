package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Dept;

public interface DeptService {
	public List<Dept> findAllDept();
	
	public Dept findDeptByDname(String dname);

	public Dept findDeptByDid(int did);
	
	public Dept findDeptAndPostByDid(int did);

	public Dept findDeptByUid(int uid);
	
	public int addDept(Dept dept);
	
	public int delDept(int did);
	
	public int updateDept(Dept dept);

	public List<Dept> findAllDeptNoPost();
	
}
