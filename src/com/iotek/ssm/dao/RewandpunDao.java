package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Rewandpun;

public interface RewandpunDao {
	public List<Rewandpun> queryRapByRptime(String rptime);
	
	public List<Rewandpun> queryRapByRptimeAndUid(String rptime,int uid);
	
	public int insertRap(Rewandpun rap);
}
