package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Recruit;

public interface RecruitService {
	public List<Recruit> findAllRecruit();
	
	public int addRecruit(Recruit recruit);
	
	public int delRecruit(int rid);
	
	public int updateRecruit(Recruit recruit);
}
