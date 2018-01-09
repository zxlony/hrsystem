package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Msg;

public interface MsgService {
	
	public int addMsg(Msg msg);

	public List<Msg> findMsgByUid(int uid);

	public int delMsg(int mid);
}
