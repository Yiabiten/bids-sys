package com.designpatternsproject.encheres.entities;

import java.util.Date;

public class Produit {
	
	private Long idProduit;
	private String name;
	private String etat;
	private String photo;
	private Long prixMin;
	private Date dateExp;
	private User owner;
	// getters & setters
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Long getPrixMin() {
		return prixMin;
	}
	public void setPrixMin(Long prixMin) {
		this.prixMin = prixMin;
	}
	public Date getDateExp() {
		return dateExp;
	}
	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}
	
	// Constructors
	
	public Produit(String name, String etat, String photo, Long min,
			Date dateExp) {
		super();
		this.name = name;
		this.etat = etat;
		this.photo = photo;
		this.prixMin = min;
		this.dateExp = dateExp;
	}
	
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
