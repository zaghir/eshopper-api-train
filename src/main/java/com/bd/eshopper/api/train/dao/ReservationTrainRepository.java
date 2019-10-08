package com.bd.eshopper.api.train.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.eshopper.api.train.entity.train.ReservationTrain;

public interface ReservationTrainRepository extends JpaRepository<ReservationTrain, Long> {

}
