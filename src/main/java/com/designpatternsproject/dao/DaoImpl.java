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
import com.designpatternsproject.entities.Role;
import com.designpatternsproject.entities.User;

public class DaoImpl implements IBidsDao {
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
		Produit p = em.find(Produit.class, idProd);
		if (p != null) {
			em.remove(p);
			return true;
		}
		return false;
	}

	@Override
	public Produit getProduct(Long idProd) {

		return em.find(Produit.class, idProd);
	}

	@Override
	public List<Produit> getPrdoductsByUser(User u) {
		if (u != null) {
			Query q = em.createQuery("select p from Produit p where p.user=:y");
			q.setParameter("y", u);
			if (q.getResultList().size() != 0) {
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
		Query q = em.createQuery("select p from Produit p ");
		if (q.getResultList().size() != 0) {
			return q.getResultList();
		}
		return null;
	}

	@Override
	public List<Produit> getOthersProduct(User u) {
		if (u != null) {
			Query q = em
					.createQuery("select p from Produit p where p.user!=:y");
			q.setParameter("y", u);
			if (q.getResultList().size() != 0) {
				return q.getResultList();
			}

		}
		return null;
	}

	@Override
	public Long getLimit(User u, Produit p) {
		if (u != null && p != null) {
			Query q = em
					.createQuery("select l from Limitation l where l.produit=:x and l.user=:y");
			q.setParameter("x", p);
			q.setParameter("y", u);

			List l = q.getResultList();
			if (l == null || l.size() == 0) {
				return -1L;
			}
			return ((Limitation) l.get(0)).getMaxBids();

		}
		return -1L;
	}

	@Override
	public List<Bid> getBids(User u, Produit p) {
		if (u != null && p != null) {
			Query q = em
					.createQuery("select b from Bid b where b.produit=:x and b.user=:y");
			q.setParameter("x", p);
			q.setParameter("y", u);

			List l = q.getResultList();
			if (l == null || l.size() == 0) {
				return null;
			}
			return l;

		}
		return null;
	}

	@Override
	public List<Bid> getBidsByUser(User u) {
		if (u != null) {
			Query q = em.createQuery("select b from Bid b where b.user=:y");
			q.setParameter("y", u);
			List l = q.getResultList();
			if (l == null || l.size() == 0) {
				return null;
			}
			return l;

		}
		return null;
	}

	@Override
	public List<Bid> getBidsOnProd(Produit p) {
		if (p != null) {
			Query q = em
					.createQuery("select b from Bid b where b.produit=:y order by b.dateBid DESC");
			q.setParameter("y", p);
			List l = q.getResultList();
			if (l == null || l.size() == 0) {
				return null;
			}
			return l;

		}
		return null;
	}

	@Override
	public boolean bid(Produit p, Long prixBids, User u) {

		if (p == null || u == null)
			return false;

		Bid b = new Bid(new Date(), prixBids);
		b.setProduit(p);
		b.setUser(u);

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
		if (c == null || u == null)
			return false;
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
		if (mail != null && password != null) {
			Query q = em
					.createQuery("select u from User u where u.username=:x and u.password=:y");
			q.setParameter("x", mail);
			q.setParameter("y", password);

			List l = q.getResultList();
			if (l == null || l.size() == 0) {
				return null;
			}
			return (User) l.get(0);

		}
		return null;
	}

	@Override
	public User findUserByUsername(String a) {
		if (a != null && !a.equals("")) {
			Query q = em
					.createQuery("select u from User u where u.username=:x");
			q.setParameter("x", a);

			List l = q.getResultList();
			if (l == null || l.size() == 0) {
				return null;
			}
			return (User) l.get(0);

		}
		return null;
	}

	@Override
	public Long getCountBidsUserOnProd(User user, Produit pr) {
		if (user != null && pr != null) {
			Query q = em
					.createQuery("select count(b) from Bid b where b.user=:x and b.produit=:y ");
			q.setParameter("x", user);
			q.setParameter("y", pr);
			return (Long) q.getResultList().get(0);

		}
		return 0L;
	}

	@Override
	public Long getCurrentMaxBidOnProd(Produit pr) {
		if (pr != null) {
			Query q = em
					.createQuery("select b from Bid b where  b.produit=:y order by b.montant DESC");
			q.setParameter("y", pr);

			System.out.println("in heeeeeeeeere :0");
			List l = q.getResultList();
			if (l == null || l.isEmpty()) {
				System.out.println("in heeeeeeeeere :1");
				return 0L;
			}

			System.out.println("in heeeeeeeeere :2");
			return ((Bid) l.get(0)).getMontant();

		}
		System.out.println("in heeeeeeeeere :3");
		return 0L;
	}

	@Override
	public Role getRole(String s) {
		if (s != null && !s.equals("")) {
			Query q = em
					.createQuery("select r from Role r where r.roleName=:x");
			q.setParameter("x", s);

			List l = q.getResultList();
			if (l == null || l.size() == 0) {
				return null;
			}
			return (Role) l.get(0);

		}
		return null;

	}

	@Override
	public boolean addLimit(User ad, User u, Produit p, Long value) {
		Limitation l = new Limitation(value, u, p);
		l.setAdmin(ad);
		
		em.persist(l);

		return true;
	}

	@Override
	public Limitation editLimit(Limitation l) {
		// TODO Auto-generated method stub
		if (l != null)
			l = em.merge(l);
		return l;
	}

	@Override
	public Limitation findLimitation(User u, Produit p) {
		if (u != null && p != null) {
			Query q = em
					.createQuery("select l from Limitation l where  l.user=:x and l.produit=:y");
			q.setParameter("y", p);
			q.setParameter("x", u);

			List l = q.getResultList();
			if (l == null || l.isEmpty())
				return null;

			return (Limitation) l.get(0);

		}

		return null;
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		Query q = em.createQuery("select u from User u ");
		
			return q.getResultList();
	}

	@Override
	public void editUser(User u) {
		if(u!=null)
			em.merge(u);
		
	}

}
