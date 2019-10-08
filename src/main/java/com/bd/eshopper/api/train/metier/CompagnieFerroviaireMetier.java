package com.bd.eshopper.api.train.metier;

import java.util.List;

import com.bd.eshopper.api.train.entity.train.CompagnieFerroviaire;

public interface CompagnieFerroviaireMetier {
	
	public CompagnieFerroviaire findOne(Long id) ;
	public List<CompagnieFerroviaire> getAll();
	public CompagnieFerroviaire save(CompagnieFerroviaire o) ;
	public CompagnieFerroviaire update(CompagnieFerroviaire o) ;
	public String delete(Long id) ;

}
