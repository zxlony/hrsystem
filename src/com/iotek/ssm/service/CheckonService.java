package com.iotek.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iotek.ssm.entity.Checkon;

public interface CheckonService {
	
	public int addCheckon(Checkon checkon);

	public List<Checkon> findCheckonByUid(@Param("uid")int uid, @Param("clockMonth")String clockMonth);

	public Checkon findByUidAndClock(int uid, String clockDate);

	public int updateCheckon(Checkon checkon);
}
