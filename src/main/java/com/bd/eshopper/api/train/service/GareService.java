package com.bd.eshopper.api.train.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.api.train.entity.train.Gare;
import com.bd.eshopper.api.train.metier.GareMetier;

@RestController
public class GareService {

	@Autowired
	private GareMetier gareMetier;

	@GetMapping(value="/api/train/gare" )
	@ResponseBody
	public List<Gare> getAll(){
				
		return gareMetier.getAll();
	}
	
	@PostMapping(value="/api/train/gare" )
	//@Secured(value = { "ROLE_ADMIN" })
	public Gare save(@RequestBody Gare o){
		return gareMetier.save(o);
	}
	
	@PutMapping(value="/api/train/gare" )
	//@Secured(value = { "ROLE_ADMIN" })
	public Gare update(@RequestBody Gare o){
		return gareMetier.update(o);		
	}

	@DeleteMapping(value="/api/train/gare" )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return gareMetier.delete(id);
	}
	
	@GetMapping(value="/api/train/gare/{id}" )
	public Gare findOne(@PathVariable Long id){
		return gareMetier.findOne(id);
	}
}
