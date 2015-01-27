package com.designpatternsproject.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.designpatternsproject.dao.IBidsDao;
import com.designpatternsproject.encheres.entities.Bid;
import com.designpatternsproject.encheres.entities.Card;
import com.designpatternsproject.encheres.entities.Produit;
import com.designpatternsproject.encheres.entities.User;
@Transactional
public class MetierImpl implements IBidsMetier {

	private IBidsDao dao;
	
	public void setDao(IBidsDao dao) {
		this.dao = dao;
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return dao.addUser(u);
	}

	@Override
	public Produit addProduit(Produit p) {
		// TODO Auto-generated method stub
		return dao.addProduit(p);
	}

	@Override
	public Card addCard(User u, Card c) {
		// TODO Auto-generated method stub
		return dao.addCard(u, c);
	}

	@Override
	public boolean addBid(User u, Produit p, long val) {
		// TODO Auto-generated method stub
		return dao.addBid(u, p, val);
	}

	@Override
	public Object authenticate(String usr, String pwd) {
		// TODO Auto-generated method stub
		return dao.authenticate(usr, pwd);
	}

	@Override
	public User readAccount(String username) {
		// TODO Auto-generated method stub
		return dao.readAccount(username);
	}

	@Override
	public List<Bid> getOperations(String username) {
		// TODO Auto-generated method stub
		return dao.getOperations(username);
	}

	@Override
	public List<Card> getCards(String username) {
		// TODO Auto-generated method stub
		return dao.getCards(username);
	}

}
