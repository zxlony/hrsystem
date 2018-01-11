package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Dept;

public interface DeptDao {
	public List<Dept> queryAllDept();
	
	public Dept queryDeptByDname(String dname);

	public Dept queryDeptByDid(int did);
	
	public Dept queryDeptAndPostByDid(int did);

	public Dept queryDeptByUid(int uid);
	
	public int insertDept(Dept dept);
	
	public int deleteDept(int did);
	
	public int updateDept(Dept dept);
}
