package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Checkon;

public interface CheckonService {
	
	public int addCheckon(Checkon checkon);

	public List<Checkon> findCheckonByUid(int uid, String clockMonth);

	public Checkon findByUidAndClock(int uid, String clockDate);

	public int updateCheckon(Checkon checkon);
}
