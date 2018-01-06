package com.iotek.ssm.service;

import com.iotek.ssm.entity.Msg;

public interface MsgService {
	
	public int addMsg(Msg msg);

	public Msg findMsgByUid(int uid);

	public int delMsg(int mid);
}
