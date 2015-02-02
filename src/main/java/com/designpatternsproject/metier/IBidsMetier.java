package com.designpatternsproject.metier;

import java.util.List;

import com.designpatternsproject.entities.Bid;
import com.designpatternsproject.entities.Card;
import com.designpatternsproject.entities.Limitation;
import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.entities.User;

public interface IBidsMetier {
	public Produit addProduit(Produit p);
	public Produit editProduct(Produit p);
	public boolean deleteProduct(Long idProd);
	public Produit getProduct(Long idProd);
	public List<Produit> getPrdoductsByUser(User u);
	public List<Produit> getWonPrdoducts(User u);
	public List<Produit> getAllPrdoducts();
	public List<Produit> getOthersProduct(User u);
	public Long getLimit(User u, Produit p);
	public List<Bid> getBids(User u, Produit p);
	public List<Bid> getBidsByUser(User u);
	public List<Bid> getBidsOnProd(Produit p);
	public boolean bid(Produit p, Long prixBids, User u);
	public User addUser(User u);
	public boolean addCard(User u, Card c);
	public Card editCard(Card c);
	public List<Card> getCards(String username);
	public User authenticate(String mail, String password);
	
}
