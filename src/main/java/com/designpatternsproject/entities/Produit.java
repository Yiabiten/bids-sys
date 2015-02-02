package com.designpatternsproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="PRODUIT")
public class Produit implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	
	
	private String name;
	private String etat;
	private String photo;
	private Long prixMin;
	private Date dateExp;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 
	
	
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy="produit", fetch=FetchType.EAGER)
	private Collection<Bid> bids;
	
	
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
	public Collection<Bid> getBids() {
		if(bids==null)
			bids= new ArrayList<Bid>();
		return bids;
	}
	public void setBids(Collection<Bid> bids) {
		this.bids = bids;
	}
	
	public Produit(String name, String etat, String photo, Long prixMin,
			Date dateExp) {
		super();
		this.name = name;
		this.etat = etat;
		this.photo = photo;
		this.prixMin = prixMin;
		this.dateExp = dateExp;
	}
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
