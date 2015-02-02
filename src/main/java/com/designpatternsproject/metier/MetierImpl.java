package com.designpatternsproject.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.designpatternsproject.dao.IBidsDao;
import com.designpatternsproject.entities.Bid;
import com.designpatternsproject.entities.Card;
import com.designpatternsproject.entities.Limitation;
import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.entities.User;
@Transactional
public class MetierImpl implements IBidsMetier {

	private IBidsDao dao;

	public void setDao(IBidsDao dao) {
		this.dao = dao;
	}

	@Override
	public Produit addProduit(Produit p) {
		
		return dao.addProduit(p);
	}

	@Override
	public Produit editProduct(Produit p) {
		
		return dao.editProduct(p);
	}

	@Override
	public boolean deleteProduct(Long idProd) {
		
		return dao.deleteProduct(idProd);
	}

	@Override
	public Produit getProduct(Long idProd) {
		
		return dao.getProduct(idProd);
	}

	
	@Override
	public List<Produit> getPrdoductsByUser(User u) {
		
		return dao.getPrdoductsByUser(u);
	}
	

	@Override
	public List<Produit> getWonPrdoducts(User u) {
		return dao.getWonPrdoducts(u);
	}

	@Override
	public List<Produit> getAllPrdoducts() {
		
		return dao.getAllPrdoducts();
	}

	@Override
	public List<Produit> getOthersProduct(User u) {
		
		return dao.getOthersProduct(u);
	}

	@Override
	public Long getLimit(User u, Produit p) {
		
		return dao.getLimit(u, p);
	}

	@Override
	public List<Bid> getBids(User u , Produit p) {
		
		return dao.getBids(u, p);
	}

	@Override
	public List<Bid> getBidsByUser(User u) {
		
		return dao.getBidsByUser(u);
	}

	@Override
	public List<Bid> getBidsOnProd(Produit p) {
		
		return dao.getBidsOnProd(p);
	}

	@Override
	public boolean bid(Produit p, Long prixBids, User u) {
		Long m;
		try {
			m=(long) dao.getBids(u, p).size();
		} catch (NullPointerException e) {
			m=0L;
		}
		
		Long x= dao.getLimit(u, p);
		System.out.println("hello from tst MImpl:\n"+(((m<x && x>=0) || x<0 )&& prixBids>=p.getPrixMin()));
		if(((m<x && x>=0) || x<0 )&& prixBids>=p.getPrixMin()){
			
			return dao.bid(p, prixBids, u);
		}
		return false;
	}

	@Override
	public User addUser(User u) {
		
		return dao.addUser(u);
	}

	@Override
	public boolean addCard(User u, Card c) {
		return dao.addCard(u, c);
	}

	@Override
	public Card editCard(Card c) {
		return dao.editCard(c);
	}



	@Override
	public List<Card> getCards(String username) {
		
		return dao.getCards(username);
	}

	@Override
	public User authenticate(String mail, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(mail, password);
	}

	}
