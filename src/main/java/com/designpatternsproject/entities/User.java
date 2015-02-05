package com.designpatternsproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	


	@ManyToMany
	@JoinTable(name="users_roles",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="role_id"))
	Collection<Role> roles;
	
	public Collection<Role> getRoles() {
		if(roles==null) roles=new ArrayList<Role>();
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	Collection<Card> cards;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	Collection<Bid> bids;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	Collection<Produit> prods;
	
	
	
	
	public Collection<Produit> getProds() {
		if(prods==null)
			prods= new ArrayList<Produit>();
		return prods;
	}
	public void setProds(Collection<Produit> prods) {
		this.prods = prods;
	}
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
		if(bids==null)
			 bids=new ArrayList<Bid>();
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
		if(cards==null)
			cards= new ArrayList<Card>();
		return cards;
	}
	public void setCards(Collection<Card> cards) {
		this.cards = cards;
	}

}
