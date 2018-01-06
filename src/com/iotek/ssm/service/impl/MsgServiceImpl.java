package com.iotek.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.MsgDao;
import com.iotek.ssm.entity.Msg;
import com.iotek.ssm.service.MsgService;

@Service("msgService")
public class MsgServiceImpl implements MsgService {

	@Autowired
	private MsgDao msgDao;
	
	@Override
	public int addMsg(Msg msg) {
		return msgDao.insertMsg(msg);
	}

	@Override
	public Msg findMsgByUid(int uid) {
		return msgDao.queryMsgByUid(uid);
	}

	@Override
	public int delMsg(int mid) {
		return msgDao.deleteMsg(mid);
	}

}
