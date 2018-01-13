package com.iotek.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.ssm.entity.Checkon;
import com.iotek.ssm.entity.CheckonRecord;

public interface CheckonService {
	
	public int addCheckon(Checkon checkon);

	public List<Checkon> findCheckonByUid(@Param("uid")int uid, @Param("clockMonth")String clockMonth);

	public Checkon findByUidAndClock(int uid, String clockDate);

	public int updateCheckon(Checkon checkon);
	
	public double getBase(int uid,String clockMonth);
	
	public CheckonRecord getRecord(int uid,String clockMonth);
}
