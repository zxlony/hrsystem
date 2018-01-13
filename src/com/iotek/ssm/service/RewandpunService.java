package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Rewandpun;

public interface RewandpunService {
	public List<Rewandpun> findRapByRptime(String rptime);

	public List<Rewandpun> findRapByRptimeAndUid(String rptime, int uid);

	public int addRap(Rewandpun rap);
}
