package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Msg;

public interface MsgDao {
	public int insertMsg(Msg msg);
	
	public List<Msg> queryMsgByUid(int uid);
	
	public int deleteMsg(int mid);
}
