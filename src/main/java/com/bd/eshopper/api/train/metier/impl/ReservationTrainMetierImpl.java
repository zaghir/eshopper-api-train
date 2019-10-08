package com.bd.eshopper.api.train.metier.impl;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.train.dao.ReservationTrainRepository;
import com.bd.eshopper.api.train.entity.train.ReservationTrain;

@Service
public class ReservationTrainMetierImpl implements com.bd.eshopper.api.train.metier.ReservationTrainMetier {

	@Autowired
	private ReservationTrainRepository reservationTrainRepository;
	
	@Override
	public ReservationTrain findOne(Long id) {
		return reservationTrainRepository.findById(id).get();
	}

	@Override
	public List<ReservationTrain> getAll() {
		return reservationTrainRepository.findAll();
	}

	@Override
	public ReservationTrain save(ReservationTrain o) {
		if (reservationTrainRepository.existsById(o.getId())) {
			throw new EntityExistsException("L'id " + o.getId() + "est déjà attribué pour les réservations de train");

		}
		return reservationTrainRepository.save(o);
	}

	@Override
	public ReservationTrain update(ReservationTrain o) {
		return reservationTrainRepository.save(o);
	}

	@Override
	public String delete(Long id) {
		if (id != null && reservationTrainRepository.existsById(id)) {
			reservationTrainRepository.deleteById(id);
			return "0";
		}
		else {
			return "1";
		}
	}

}
