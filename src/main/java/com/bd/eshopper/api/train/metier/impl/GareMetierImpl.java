package com.bd.eshopper.api.train.metier.impl;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.train.dao.GareRepository;
import com.bd.eshopper.api.train.entity.train.Gare;
import com.bd.eshopper.api.train.metier.GareMetier;

@Service
public class GareMetierImpl implements GareMetier {
	
	@Autowired
	private GareRepository gareRepository;

	@Override
	public Gare findOne(Long id) {
		return gareRepository.findById(id).get();
	}

	@Override
	public List<Gare> getAll() {
		return gareRepository.findAll();
	}

	@Override
	public Gare save(Gare o) {
		if (gareRepository.existsById(o.getId())) {
			throw new EntityExistsException("L'id " + o.getId() + "est déjà attribué pour les gares");
		}
		return gareRepository.save(o);
	}

	@Override
	public Gare update(Gare o) {
		return gareRepository.save(o);
	}

	@Override
	public String delete(Long id) {
		if (id != null && gareRepository.existsById(id)) {
			gareRepository.deleteById(id);
			return "0";
		}
		else {
			return "1";
		}
	}

}
