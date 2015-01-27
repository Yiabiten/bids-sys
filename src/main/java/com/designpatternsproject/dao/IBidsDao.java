package com.designpatternsproject.dao;

import java.util.List;

import com.designpatternsproject.encheres.entities.Bid;
import com.designpatternsproject.encheres.entities.Card;
import com.designpatternsproject.encheres.entities.Produit;
import com.designpatternsproject.encheres.entities.User;

public interface IBidsDao {

	public User addUser(User u);
	public Produit addProduit(Produit p);
	public Card addCard(User u, Card c);
	public boolean addBid(User u, Produit p,long val);
	
	public Object authenticate(String usr,String pwd);
	
	User readAccount(String username);
	List<Bid> getOperations(String username);
	List<Card> getCards(String username);
	
}
