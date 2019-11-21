package com.bd.eshopper.api.train.entity.train;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Gare implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6439294373862800153L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String ville;
	
	
	public Gare() {
		super();
	}


	public Gare(String nom, String ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Gare [id=" + id + ", nom=" + nom + ", ville=" + ville + "]";
	}
	
	
	
	
	
	
	

}
