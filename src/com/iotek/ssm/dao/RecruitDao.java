package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Recruit;

public interface RecruitDao {
	public List<Recruit> queryAllRecruit();
	
	public int insertRecruit(Recruit recruit);
	
	public int deleteRecruit(int rid);
	
	public int updateRecruit(Recruit recruit);
}
