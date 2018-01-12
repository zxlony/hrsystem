package com.iotek.ssm.service;

import java.util.List;

import com.iotek.ssm.entity.Train;

public interface TrainService {
	public List<Train> findTrainAll();

	public Train findTrainByTid(int tid);

	public int addTrain(Train train);

	public int delTrain(int tid);

	public int updateTrain(Train train);

	public List<Train> findTrainByDid(int did);
}
