package com.iotek.ssm.dao;

import com.iotek.ssm.entity.Resume;

public interface ResumeDao {

	public Resume queryResumeByUid(int uid);
	
	public int insertResume(Resume resume);

	public int updateResume(Resume resume);

}
