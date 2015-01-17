package com.designpatternsproject.encheres.entities;

import java.util.Date;

public class Bid {
	
	
	private Long id;
	private Produit prod;
	private Date dateBid;
	private Card carte;
	private User user;
	private Long montant;
	
	// Getters & Setters
	
	
	
	public Long getMontant() {
		return montant;
	}
	public void setMontant(Long montant) {
		this.montant = montant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produit getProd() {
		return prod;
	}
	public void setProd(Produit prod) {
		this.prod = prod;
	}
	public Date getDateBid() {
		return dateBid;
	}
	public void setDateBid(Date dateBid) {
		this.dateBid = dateBid;
	}
	public Card getCarte() {
		return carte;
	}
	public void setCarte(Card carte) {
		this.carte = carte;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	// Constructors
	
	public Bid(Produit prod, Date dateBid, Card carte, User user, Long montant) {
		super();
		this.prod = prod;
		this.dateBid = dateBid;
		this.carte = carte;
		this.user = user;
		this.montant = montant;
	}
	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
