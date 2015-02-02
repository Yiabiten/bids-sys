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
	public List<Produit> getPrdoductsByUser(User u) {
		if(u!=null ){
			Query q=em.createQuery("select p from Produit p where p.user=:y");
			q.setParameter("y", u);
			if(q.getResultList().size()!=0){
				return q.getResultList();
			}
			
		}
		return null;
	}
	

	@Override
	public List<Produit> getWonPrdoducts(User u) {
		
		return null;
	}

	@Override
	public List<Produit> getAllPrdoducts() {
		Query q=em.createQuery("select p from Produit p ");
		if(q.getResultList().size()!=0){
			return q.getResultList();
		}
		return null;
	}

	@Override
	public List<Produit> getOthersProduct(User u) {
		if(u!=null ){
			Query q=em.createQuery("select p from Produit p where p.user!=:y");
			q.setParameter("y", u);
			if(q.getResultList().size()!=0){
				return q.getResultList();
			}
			
		}
		return null;
	}

	@Override
	public Long getLimit(User u,  Produit p) {
		if(u!=null && p!=null){
			Query q=em.createQuery("select l from Limitation l where l.produit=:x and l.user=:y");
			q.setParameter("x", p);
			q.setParameter("y", u);
			
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return -1L;
			}
			return ((Limitation)l.get(0)).getMaxBids();
			
		}
		return -1L;
	}

	@Override
	public List<Bid> getBids(User u, Produit p) {
		if(u!=null && p!=null){
			Query q=em.createQuery("select b from Bid b where b.produit=:x and b.user=:y");
			q.setParameter("x", p);
			q.setParameter("y", u);
			
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return null;
			}
			return l;
			
		}
		return null;
	}

	@Override
	public List<Bid> getBidsByUser(User u) {
		if(u!=null ){
			Query q=em.createQuery("select b from Bid b where b.user=:y");
			q.setParameter("y", u);
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return null;
			}
			return l;
			
		}
		return null;
	}

	@Override
	public List<Bid> getBidsOnProd(Produit p) {
		if(p!=null ){
			Query q=em.createQuery("select b from Bid b where b.produit=:y");
			q.setParameter("y", p);
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return null;
			}
			return l;
			
		}
		return null;
	}

	@Override
	public boolean bid(Produit p, Long prixBids, User u) {
		
		
		if(p==null || u ==null) return false;
		
		Bid b = new Bid(new Date(), prixBids);
		b.setProduit(p); b.setUser(u);
		
		u.getBids().add(b);
		p.getBids().add(b);
		
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

	@Override
	public User authenticate(String mail, String password) {
		if(mail!=null && password!=null){
			Query q=em.createQuery("select u from User u where u.username=:x and u.password=:y");
			q.setParameter("x", mail);
			q.setParameter("y", password);
			
			List l=q.getResultList();
			if (l==null || l.size()==0) {
				return null;
			}
			return (User) l.get(0);
			
		}
		return null;
	}


	
}
