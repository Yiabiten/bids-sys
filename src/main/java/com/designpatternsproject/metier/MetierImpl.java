package com.designpatternsproject.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.designpatternsproject.dao.IBidsDao;
import com.designpatternsproject.entities.Bid;
import com.designpatternsproject.entities.Card;
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
	public List<Produit> getPrdoductsByUser(Long idUser) {
		
		return dao.getPrdoductsByUser(idUser);
	}

	@Override
	public List<Produit> getWonPrdoducts(Long idUser) {
		
		return dao.getWonPrdoducts(idUser);
	}

	@Override
	public List<Produit> getAllPrdoducts() {
		
		return dao.getAllPrdoducts();
	}

	@Override
	public List<Produit> getOthersProduct(Long idUser) {
		
		return dao.getOthersProduct(idUser);
	}

	@Override
	public Long getLimit(Long idUser, Long idProd) {
		
		return dao.getLimit(idUser, idProd);
	}

	@Override
	public List<Bid> getBids(Long idUser, Long idProd) {
		
		return dao.getBids(idUser, idProd);
	}

	@Override
	public List<Bid> getBidsByUser(Long idUser) {
		
		return dao.getBidsByUser(idUser);
	}

	@Override
	public List<Bid> getBidsOnProd(Long idProd) {
		
		return dao.getBidsOnProd(idProd);
	}

	@Override
	public boolean bid(Long idProduit, Long prixBids, Long idUser) {
		
		return dao.bid(idProduit, prixBids, idUser);
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
	}
