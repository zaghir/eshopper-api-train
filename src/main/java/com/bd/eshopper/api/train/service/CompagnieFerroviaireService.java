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

import com.bd.eshopper.api.train.entity.train.CompagnieFerroviaire;
import com.bd.eshopper.api.train.metier.CompagnieFerroviaireMetier;

@RestController
public class CompagnieFerroviaireService {
	
	@Autowired
	private CompagnieFerroviaireMetier compagnieFerroviaireMetier;

	@GetMapping(value="/api/train/compagnie-ferroviaire" )
	@ResponseBody
	public List<CompagnieFerroviaire> getAll(){
				
		return compagnieFerroviaireMetier.getAll();
	}
	
	@PostMapping(value="/api/train/compagnie-ferroviaire" )
	//@Secured(value = { "ROLE_ADMIN" })
	public CompagnieFerroviaire save(@RequestBody CompagnieFerroviaire o){
		return compagnieFerroviaireMetier.save(o);
	}
	
	@PutMapping(value="/api/train/compagnie-ferroviaire" )
	//@Secured(value = { "ROLE_ADMIN" })
	public CompagnieFerroviaire update(@RequestBody CompagnieFerroviaire o){
		return compagnieFerroviaireMetier.update(o);		
	}

	@DeleteMapping(value="/api/train/compagnie-ferroviaire" )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return compagnieFerroviaireMetier.delete(id);
	}
	
	@GetMapping(value="/api/train/compagnie-ferroviaire/{id}" )
	public CompagnieFerroviaire findOne(@PathVariable Long id){
		return compagnieFerroviaireMetier.findOne(id);
	}
}
