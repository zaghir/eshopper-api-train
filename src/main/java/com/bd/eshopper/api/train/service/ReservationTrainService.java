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

import com.bd.eshopper.api.train.entity.train.ReservationTrain;
import com.bd.eshopper.api.train.metier.ReservationTrainMetier;

@RestController
public class ReservationTrainService {
	
	@Autowired
	private ReservationTrainMetier reservationTrainMetier;

	@RequestMapping(value="/api/train/reservation-train" , method=RequestMethod.GET )
	@ResponseBody
	public List<ReservationTrain> getAll(){
				
		return reservationTrainMetier.getAll();
	}
	
	@RequestMapping(value="/api/train/reservation-train" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public ReservationTrain save(@RequestBody ReservationTrain o){
		return reservationTrainMetier.save(o);
	}
	
	@RequestMapping(value="/api/train/reservation-train" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public ReservationTrain update(@RequestBody ReservationTrain o){
		return reservationTrainMetier.update(o);		
	}

	@RequestMapping(value="/api/train/reservation-train" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		return reservationTrainMetier.delete(id);
	}
	
	@RequestMapping(value="/api/train/reservation-train/{id}" , method=RequestMethod.GET )
	public ReservationTrain findOne(@PathVariable Long id){
		return reservationTrainMetier.findOne(id);
	}

}
