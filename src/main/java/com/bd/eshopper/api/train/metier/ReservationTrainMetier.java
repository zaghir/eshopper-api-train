package com.bd.eshopper.api.train.metier;

import java.util.List;

import com.bd.eshopper.api.train.entity.train.ReservationTrain;

public interface ReservationTrainMetier {

	public ReservationTrain findOne(Long id) ;
	public List<ReservationTrain> getAll();
	public ReservationTrain save(ReservationTrain o) ;
	public ReservationTrain update(ReservationTrain o) ;
	public String delete(Long id) ;

}
