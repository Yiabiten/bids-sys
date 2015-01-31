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
	public List<Produit> getPrdoductsByUser(Long idUser);
	public List<Produit> getWonPrdoducts(Long idUser);
	public List<Produit> getAllPrdoducts();
	public List<Produit> getOthersProduct(Long idUser);
	public Long getLimit(Long idUser, Long idProd);
	public List<Bid> getBids(Long idUser, Long idProd);
	public List<Bid> getBidsByUser(Long idUser);
	public List<Bid> getBidsOnProd(Long idProd);
	public boolean bid(Long idProduit, Long prixBids, Long idUser);
	public User addUser(User u);
	public boolean addCard(User u, Card c);
	public Card editCard(Card c);
	public List<Card> getCards(String username);
	
}
