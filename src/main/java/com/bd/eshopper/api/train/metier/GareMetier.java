package com.bd.eshopper.api.train.metier;

import java.util.List;

import com.bd.eshopper.api.train.entity.train.Gare;

public interface GareMetier {

	public Gare findOne(Long id) ;
	public List<Gare> getAll();
	public Gare save(Gare o) ;
	public Gare update(Gare o) ;
	public String delete(Long id) ;

}
