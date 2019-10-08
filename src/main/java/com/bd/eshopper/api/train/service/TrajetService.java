package com.bd.eshopper.api.train.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.api.train.entity.train.Trajet;
import com.bd.eshopper.api.train.metier.TrajetMetier;

@RestController
public class TrajetService {
	
	@Autowired
	private TrajetMetier trajetMetier;

	@RequestMapping(value="/api/train/trajet" , method=RequestMethod.GET )
	@ResponseBody
	public List<Trajet> getAll(){
				
		return trajetMetier.getAll();
	}
	
	@RequestMapping(value="/api/train/trajet" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Trajet save(@RequestBody Trajet o){
		return trajetMetier.save(o);
	}
	
	@RequestMapping(value="/api/train/trajet" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public Trajet update(@RequestBody Trajet o){
		return trajetMetier.update(o);		
	}

	@RequestMapping(value="/api/train/trajet" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return trajetMetier.delete(id);
	}
	
	@RequestMapping(value="/api/train/trajet/{id}" , method=RequestMethod.GET )
	public Trajet findOne(@PathVariable Long id){
		return trajetMetier.findOne(id);
	}

}
