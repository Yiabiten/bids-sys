package com.designpatternsproject.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.designpatternsproject.encheres.entities.Bid;
import com.designpatternsproject.encheres.entities.Card;
import com.designpatternsproject.encheres.entities.Produit;
import com.designpatternsproject.encheres.entities.User;

public class DaoImpl implements IBidsDao{
	@PersistenceContext
	private EntityManager em;

	@Override
	public User addUser(User u) {
		em.persist(u);
		return u;
	}

	@Override
	public Produit addProduit(Produit p) {
		em.persist(p);
		return p;
	}

	@Override
	public Card addCard(User u, Card c) {
		u.getCards().add(c);
		c.setUser(u);
		return c;
	}

	@Override
	public boolean addBid(User u, Produit p, long val) {
		
		
		//testé valeur max
		Bid b = new Bid(new Date(), val);
		b.setProduit(p);
		b.setUser(u);
		u.getBids().add(b);
		em.persist(b);
		em.persist(u);
		return b!=null;
	}

	@Override
	public Object authenticate(String usr, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bid> getOperations(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Card> getCards(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
