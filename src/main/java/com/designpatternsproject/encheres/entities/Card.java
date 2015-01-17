package com.designpatternsproject.encheres.entities;

import java.util.Date;

public class Card {
	private  Long idCard;
	private String provider;
	private String owner;
	private Date expireDate;
	private  Long numCard;
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
