package com.iotek.ssm.dao;

import java.util.List;

import com.iotek.ssm.entity.Train;

public interface TrainDao {
	public List<Train> queryTrainAll();
	
	public Train queryTrainByTid(int tid);
	
	public int insertTrain(Train train);
	
	public int deleteTrain(int tid);
	
	public int updateTrain(Train train);

	public List<Train> queryTrainByDid(int did);
}
