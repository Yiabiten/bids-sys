package com.designpatternsproject.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.designpatternsproject.entities.Bid;
import com.designpatternsproject.entities.Card;
import com.designpatternsproject.entities.Limitation;
import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.entities.User;

public class DaoImpl implements IBidsDao{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Produit addProduit(Produit p) {
		em.persist(p);
		return p;
	}
 
	@Override
	public Produit editProduct(Produit p) {
		em.merge(p);
		return p;
	}

	@Override
	public boolean deleteProduct(Long idProd) {
		
		return false;
	}

	@Override
	public Produit getProduct(Long idProd) {
		
		return em.find(Produit.class, idProd);
	}

	@Override
	public List<Produit> getPrdoductsByUser(Long idUser) {
		if(idUser!=null && idUser!=0){
			Query q=em.createQuery("select p from Produit p where p.idUser=:y");
			q.setParameter("y", idUser);
			if(q.getResultList().size()!=0){
				return q.getResultList();
			}
			
		}
		return null;
	}

	@Override
	public List<Produit> getWonPrdoducts(Long idUser) {
		
		return null;
	}

	@Override
	public List<Produit> getAllPrdoducts() {
		Query q=em.createQuery("select p from Produit p orderby dateExp");
		if(q.getResultList().size()!=0){
			return q.getResultList();
		}
		return null;
	}

	@Override
	public List<Produit> getOthersProduct(Long idUser) {
		if(idUser!=null && idUser!=0){
			Query q=em.createQuery("select p from Produit p where p.idUser!=:y");
			q.setParameter("y", idUser);
			if(q.getResultList().size()!=0){
				return q.getResultList();
			}
			
		}
		return null;
	}

	@Override
	public Long getLimit(Long idUser, Long idProd) {
		if(idUser!=null && idProd!=null){
			Query q=em.createQuery("select l from Limit l where l.product_id=:x and l.user_id=:y");
			q.setParameter("x", idProd);
			q.setParameter("y", idUser);
			
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return -1L;
			}
			return ((Limitation)l.get(0)).getMaxBids();
			
		}
		return -1L;
	}

	@Override
	public List<Bid> getBids(Long idUser, Long idProd) {
		if(idUser!=null && idProd!=null){
			Query q=em.createQuery("select b from Bid b where b.PRODUCT_ID=:x and b.USER_ID=:y");
			q.setParameter("x", idProd);
			q.setParameter("y", idUser);
			
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return null;
			}
			return l;
			
		}
		return null;
	}

	@Override
	public List<Bid> getBidsByUser(Long idUser) {
		if(idUser!=null ){
			Query q=em.createQuery("select b from Bid b where b.USER_ID=:y");
			q.setParameter("y", idUser);
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return null;
			}
			return l;
			
		}
		return null;
	}

	@Override
	public List<Bid> getBidsOnProd(Long idProd) {
		if(idProd!=null ){
			Query q=em.createQuery("select b from Bid b where b.PRODUCT_ID=:y");
			q.setParameter("y", idProd);
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return null;
			}
			return l;
			
		}
		return null;
	}

	@Override
	public boolean bid(Long idProduit, Long prixBids, Long idUser) {
		
		Produit p = em.find(Produit.class, idProduit);
		User u = em.find(User.class, idUser);
		if(p==null || u ==null) return false;
		
		Bid b = new Bid(new Date(), prixBids);
		b.setProduit(p); b.setUser(u);
		em.persist(b);
		return true;
	}

	@Override
	public User addUser(User u) {
		em.persist(u);
		return u;
	}

	@Override
	public boolean addCard(User u, Card c) {
		if(c==null || u==null) return false;
		u.getCards().add(c);
		c.setUser(u);
		return true;
		
	}

	@Override
	public Card editCard(Card c) {
		em.merge(c);
		return c;
	}

	@Override
	public List<Card> getCards(String username) {
		return null;
	}


	
}
