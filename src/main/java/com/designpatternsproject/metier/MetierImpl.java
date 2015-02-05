package com.designpatternsproject.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.designpatternsproject.dao.IBidsDao;
import com.designpatternsproject.entities.Bid;
import com.designpatternsproject.entities.Card;
import com.designpatternsproject.entities.Limitation;
import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.entities.Role;
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
			
			return dao.bid(p, prixBids, u);
		
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

	@Override
	public User findUserByUsername(String a) {
		return dao.findUserByUsername(a);
	}

	@Override
	public Long getCountBidsUserOnProd(User user, Produit pr) {
		// TODO Auto-generated method stub
		return dao.getCountBidsUserOnProd(user, pr) ;
	}

	@Override
	public Long getCurrentMaxBidOnProd(Produit pr) {
		// TODO Auto-generated method stub
		return dao.getCurrentMaxBidOnProd(pr);
	}

	@Override
	public Role getRole(String s) {
		// TODO Auto-generated method stub
		return dao.getRole(s);
	}

	@Override
	public boolean addLimit(User ad, User u, Produit p, Long value) {
		
		return dao.addLimit(ad, u, p, value);
	}

	@Override
	public Limitation editLimit(Limitation l) {
		// TODO Auto-generated method stub
		return dao.editLimit(l);
	}

	@Override
	public Limitation findLimitation(User u, Produit p) {
		// TODO Auto-generated method stub
		return dao.findLimitation(u,p);
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return dao.getUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

	@Override
	public void editUser(User u) {
		dao.editUser(u);
		
	}

	@Override
	public void payForService(User user, int priceOfService) {
		if(user==null) return;
		System.out.println(user.getUsername()+" payed "+priceOfService);
		
	}

	}
