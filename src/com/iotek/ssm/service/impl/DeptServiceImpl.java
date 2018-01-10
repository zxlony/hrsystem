package com.iotek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.DeptDao;
import com.iotek.ssm.entity.Dept;
import com.iotek.ssm.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDao deptDao;

	@Override
	public List<Dept> findAllDept() {
		return deptDao.queryAllDept();
	}

	@Override
	public Dept findDeptByDname(String dname) {
		return deptDao.queryDeptByDname(dname);
	}

	@Override
	public Dept findDeptByDid(int did) {
		return deptDao.queryDeptByDid(did);
	}

	@Override
	public Dept findDeptByUid(int uid) {
		return deptDao.queryDeptByUid(uid);
	}

}
