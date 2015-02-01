package com.designpatternsproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARD")
public class Card implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long idCard;
	
	private String provider;
	private String owner;
	private Date expireDate;
	private  Long numCard;
	@ManyToOne
	@JoinColumn(name="user_id")
	private  User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getIdCard() {
		return idCard;
	}
	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public Long getNumCard() {
		return numCard;
	}
	public void setNumCard(Long numCard) {
		this.numCard = numCard;
	}
	public Card(String provider, String owner, Date expireDate, Long numCard) {
		super();
		this.provider = provider;
		this.owner = owner;
		this.expireDate = expireDate;
		this.numCard = numCard;
	}
	
	

}
