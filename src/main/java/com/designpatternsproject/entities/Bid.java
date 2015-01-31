package com.designpatternsproject.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="BID")
public class Bid {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date dateBid;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	
	private Long montant;

	
	
	// Getters & Setters

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateBid() {
		return dateBid;
	}


	public void setDateBid(Date dateBid) {
		this.dateBid = dateBid;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Long getMontant() {
		return montant;
	}


	public void setMontant(Long montant) {
		this.montant = montant;
	}
	
	// Constructors


	public Bid(Date dateBid, Long montant) {
		super();
		this.dateBid = dateBid;
		this.montant = montant;
	}


	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	

	
	
	
	
	

}
