package com.designpatternsproject.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	private String firstName;
	private String lastName;
	
	private String phone;
	private String address;
	private String username;
	private String password;
	private String profession;
	private boolean bloqued;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	Collection<Card> cards;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	Collection<Bid> bids;
	
	
	public User(String firstName, String lastName, String phone,
			String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.bloqued=false;
		this.address="address: xx, XXXX XXXX XXX XXXXX - XXXXXX, XXXXXXXX";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isBloqued() {
		return bloqued;
	}
	public void setBloqued(boolean bloqued) {
		this.bloqued = bloqued;
	}
	
	public Collection<Bid> getBids() {
		return bids;
	}
	public void setBids(Collection<Bid> bids) {
		this.bids = bids;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Collection<Card> getCards() {
		return cards;
	}
	public void setCards(Collection<Card> cards) {
		this.cards = cards;
	}

}
