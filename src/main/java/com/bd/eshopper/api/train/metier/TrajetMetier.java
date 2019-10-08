package com.bd.eshopper.api.train.metier;

import java.util.List;

import com.bd.eshopper.api.train.entity.train.Trajet;

public interface TrajetMetier {

	public Trajet findOne(Long id) ;
	public List<Trajet> getAll();
	public Trajet save(Trajet o) ;
	public Trajet update(Trajet o) ;
	public String delete(Long id) ;

}
