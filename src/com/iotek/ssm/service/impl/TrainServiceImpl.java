package com.iotek.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.ssm.dao.TrainDao;
import com.iotek.ssm.entity.Train;
import com.iotek.ssm.service.TrainService;

@Service("trainService")
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainDao trainDao;
	
	@Override
	public List<Train> findTrainAll() {
		return trainDao.queryTrainAll();
	}

	@Override
	public Train findTrainByTid(int tid) {
		return trainDao.queryTrainByTid(tid);
	}

	@Override
	public int addTrain(Train train) {
		return trainDao.insertTrain(train);
	}

	@Override
	public int delTrain(int tid) {
		return trainDao.deleteTrain(tid);
	}

	@Override
	public int updateTrain(Train train) {
		return trainDao.updateTrain(train);
	}

	@Override
	public List<Train> findTrainByDid(int did) {
		return trainDao.queryTrainByDid(did);
	}

}
