package com.bd.eshopper.api.train.metier.impl;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.train.dao.TrajetRepository;
import com.bd.eshopper.api.train.entity.train.Trajet;
import com.bd.eshopper.api.train.metier.TrajetMetier;

@Service
public class TrajetMetierImpl implements TrajetMetier {

	@Autowired
	private TrajetRepository trajetRepository;
	
	@Override
	public Trajet findOne(Long id) {
		return trajetRepository.findById(id).get();
	}

	@Override
	public List<Trajet> getAll() {
		return trajetRepository.findAll();
	}

	@Override
	public Trajet save(Trajet o) {
		if (trajetRepository.existsById(o.getId())) {
			throw new EntityExistsException("L'id " + o.getId() + "est déjà attribué pour les trajets");
		}
		return trajetRepository.save(o);
	}

	@Override
	public Trajet update(Trajet o) {
		return trajetRepository.save(o);
	}

	@Override
	public String delete(Long id) {
		if (id != null && trajetRepository.existsById(id)) {
			trajetRepository.deleteById(id);
			return "0";
		}
		else {
			return "1";
		}
	}

}
