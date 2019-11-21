package com.bd.eshopper.api.train.metier.impl;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.train.dao.CompagnieFerroviaireRepository;
import com.bd.eshopper.api.train.entity.train.CompagnieFerroviaire;
import com.bd.eshopper.api.train.metier.CompagnieFerroviaireMetier;

@Service
public class CompagnieFerroviaireMetierImpl implements CompagnieFerroviaireMetier {
	
	@Autowired
	private CompagnieFerroviaireRepository compagnieFerroviaireRepository;

	@Override
	public CompagnieFerroviaire findOne(Long id) {
		return compagnieFerroviaireRepository.findById(id).get();
	}

	@Override
	public List<CompagnieFerroviaire> getAll() {
		return compagnieFerroviaireRepository.findAll();
	}

	@Override
	public CompagnieFerroviaire save(CompagnieFerroviaire o) {
		
		if (null != o.getId() &&compagnieFerroviaireRepository.existsById(o.getId())) {
			throw new EntityExistsException("L'id " + o.getId() + "est déjà attribué pour les compagnies ferriviaires");
		}
		return compagnieFerroviaireRepository.save(o);
	}

	@Override
	public CompagnieFerroviaire update(CompagnieFerroviaire o) {
		return compagnieFerroviaireRepository.save(o);
	}

	@Override
	public String delete(Long id) {
		if (id != null && compagnieFerroviaireRepository.existsById(id)) {
			compagnieFerroviaireRepository.deleteById(id);
			return "0";
		}
		else {
			return "1";
		}
	}

}
