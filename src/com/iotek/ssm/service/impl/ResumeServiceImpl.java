package com.iotek.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.ResumeDao;
import com.iotek.ssm.entity.Resume;
import com.iotek.ssm.service.ResumeService;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;
	
	@Override
	public Resume findResumeByUid(int uid) {
		return resumeDao.queryResumeByUid(uid);
	}

	@Override
	public int addResume(Resume resume) {
		return resumeDao.insertResume(resume);
	}

}
