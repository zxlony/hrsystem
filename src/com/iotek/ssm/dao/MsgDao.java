package com.iotek.ssm.dao;

import com.iotek.ssm.entity.Msg;

public interface MsgDao {
	public int insertMsg(Msg msg);
	
	public Msg queryMsgByUid(int uid);
	
	public int deleteMsg(int mid);
}
