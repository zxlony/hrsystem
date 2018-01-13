package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Checkon;

public interface CheckonDao {
	
	public int insertCheckon(Checkon checkon);
	
	public List<Checkon> queryCheckonByUid(int uid,String clockMonth);
	
	public Checkon queryByUidAndClock(int uid,String clockDate);
	
	public int updateCheckon(Checkon checkon);
	
	public int getStatusCount(int uid,String status);
}
