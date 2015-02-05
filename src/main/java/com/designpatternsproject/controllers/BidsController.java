package com.designpatternsproject.controllers;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.designpatternsproject.entities.Bid;
import com.designpatternsproject.entities.Limitation;
import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.entities.User;
import com.designpatternsproject.metier.IBidsMetier;
import com.designpatternsproject.models.LoginForm;

@Controller
public class BidsController {
	@Autowired
	private IBidsMetier metier;

	@RequestMapping(value = "/index")
	public String doLogin() {
		return "welcome";
	}

	@RequestMapping(value = "/limit")
	public String limit(LoginForm lf, Model model) {
		lf.setLu(null);
		lf.setLp(null);
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		lf.setUser(metier.findUserByUsername(usr.getUsername()));
		User u;
		Produit p;
		Long val;

		lf.setLp(metier.getAllPrdoducts());
		lf.setLu(metier.getAllUsers());

		try {
			u = metier.getUser(Long.parseLong(lf.getUsr()));
			p = metier.getProduct(Long.parseLong(lf.getPrd()));
			val = Long.parseLong(lf.getVal());
		} catch (Exception e) {

			lf.setError(true);
			model.addAttribute("loginForm", lf);
			return "limit";
		}

		Limitation l = metier.findLimitation(u, p);
		if (l == null)
			metier.addLimit(lf.getUser(), u, p, val);
		else {
			l.setMaxBids(Long.parseLong(lf.getVal()));
			metier.editLimit(l);
		}
		lf.setError(false);
		lf.setVal(null);
		lf.setUsr(null);
		return "limit";
	}

	@RequestMapping(value = "/block")
	public String block(LoginForm lf, Model model) {
		lf.setLu(null);
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		lf.setUser(metier.findUserByUsername(usr.getUsername()));
		User u;

		lf.setLu(metier.getAllUsers());

		try {
			u = metier.getUser(Long.parseLong(lf.getUsr()));
		} catch (Exception e) {

			lf.setError(true);
			model.addAttribute("loginForm", lf);
			return "block";
		}
		u = metier.getUser(Long.parseLong(lf.getUsr()));
		u.setBloqued(!u.isBloqued());
		metier.editUser(u);
		lf.setLu(metier.getAllUsers());
		lf.setError(false);
		lf.setVal(null);
		lf.setUsr(null);
		return "block";
	}

	@RequestMapping(value = "/register")
	public String register(LoginForm lf, Model model) {
		lf.setError(true);
		if (lf.getPwdAgain() == null) {
			lf.setError(true);
			model.addAttribute("loginForm", lf);
			return "register";
		}

		User u = metier.findUserByUsername(lf.getMail());
		if (u != null) {
			lf.setError(true);
			lf.setMail(null);
			model.addAttribute("loginForm", lf);
			return "register";
		} else if (lf.getPassword().equals(lf.getPwdAgain())) {
			u = new User(lf.getFirst(), lf.getLast(), "", lf.getMail(),
					lf.getPassword());
			u.setBloqued(false);
			u.setProfession(lf.getProf());
			metier.addUser(u);
			lf.setError(false);
			lf.setFirst(null);
			lf.setLast(null);
			lf.setMail(null);
			lf.setPassword(null);
			lf.setPwdAgain(null);
			lf.setProf(null);
			model.addAttribute("loginForm", lf);
			return "register";
		} else {
			lf.setError(true);
			lf.setPassword(null);
			lf.setPwdAgain(null);
			model.addAttribute("loginForm", lf);
			return "register";
		}

	}

	@RequestMapping(value = "/feed")
	public String latest(LoginForm lf, Model model) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		lf.setUser(metier.findUserByUsername(usr.getUsername()));

		lf.setLp(metier.getOthersProduct(lf.getUser()));
		model.addAttribute("loginForm", lf);
		return "latest";

	}

	@RequestMapping(value = "/my_products")
	public String my_prod(LoginForm lf, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		lf.setUser(metier.findUserByUsername(usr.getUsername()));
		lf.setLp(null);
		lf.setLp(metier.getPrdoductsByUser(lf.getUser()));
		model.addAttribute("loginForm", lf);
		return "my_products";
	}

	@RequestMapping(value = "/BidsHistory")
	public String my_bids(LoginForm lf, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		lf.setUser(metier.findUserByUsername(usr.getUsername()));
		lf.setLb(null);
		lf.setLb(metier.getBidsByUser(lf.getUser()));
		model.addAttribute("loginForm", lf);
		return "my_bids";
	}

	@RequestMapping(value = "/addProduct")
	public String addProd(LoginForm lf, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		lf.setUser(metier.findUserByUsername(usr.getUsername()));
		lf.setError(false);

		if (lf.getExp() == null || lf.getProdDesc() == null
				|| lf.getProdName() == null || lf.getMinPrice() == null) {
			lf.setError(true);
			model.addAttribute("loginForm", lf);
			return "addProduct";
		}

		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		int priceOfService=0;
		
		switch (Integer.parseInt(lf.getExp())) {
		case 1:
			cal.add(Calendar.DATE, 1);
			priceOfService=20;
			break;
		case 2:
			cal.add(Calendar.DATE, 7);
			priceOfService=120;
			break;
		case 3:
			cal.add(Calendar.DATE, 30);
			priceOfService=460;
			break;
		}
		d = cal.getTime();

		Produit pr = new Produit(lf.getProdName(), lf.getProdDesc(), "",
				Long.parseLong(lf.getMinPrice()), d);
		pr.setUser(lf.getUser());
		lf.getUser().getProds().add(metier.addProduit(pr));

		//***********************************************
		//**      payer selon ExpDate choice		   **
		//**payForService(lf.getUser(),priceOfService);**
		//***********************************************
		metier.payForService(lf.getUser(),priceOfService);
		
		if (lf.getMinPrice() != null)
			lf.setError(false);

		lf.setProdName(null);
		lf.setMinPrice(null);
		lf.setProdDesc(null);
		lf.setMinPrice(null);
		lf.setExp(null);

		model.addAttribute("loginForm", lf);
		return "addProduct";
	}

	@RequestMapping(value = "/addBid")
	public String add_bid(LoginForm lf, Model model,
			@RequestParam("id_prod") String id_prod) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		lf.setUser(metier.findUserByUsername(usr.getUsername()));
		lf.setLb(null);
		lf.setError(false);
		try {
			lf.setPr(metier.getProduct(Long.valueOf(id_prod)));
		} catch (Exception e) {
			lf.setError(true);
			return "bid_on_prod";
		}

		// check if prod owner is curr usr
		if (lf.getPr() == null
				|| lf.getPr().getUser().getIdUser()
						.equals(lf.getUser().getIdUser())) {
			lf.setError(true);
			model.addAttribute("loginForm", lf);
			return "bid_on_prod";
		}

		lf.setLb(metier.getBidsOnProd(lf.getPr()));

		// check if timeout
		if (lf.getPr().getDateExp().compareTo(new Date()) < 0) {
			// ^ dateExp < currDate

			lf.setTimeout(true);
			model.addAttribute("loginForm", lf);
			return "bid_on_prod";

		}

		Long M = metier.getCurrentMaxBidOnProd(lf.getPr());
		if (M > lf.getPr().getPrixMin()) {
			lf.setMax(M + 1);
		} else {
			lf.setMax(lf.getPr().getPrixMin());
		}

		if (lf.getCost() != null && lf.getCost() < lf.getMax()) {
			lf.setError(true);
			model.addAttribute("loginForm", lf);
			return "bid_on_prod";
		}

		// check if limit to be exceeded:
		// TODO ....
		M = metier.getCountBidsUserOnProd(lf.getUser(), lf.getPr());
		Long lim = metier.getLimit(lf.getUser(), lf.getPr());
		if (lim >= 0 && lim <= M) {
			lf.setError(true);
			model.addAttribute("loginForm", lf);
			return "bid_on_prod";
		}

		if (lf.getCost() != null) {
			metier.bid(lf.getPr(), lf.getCost(), lf.getUser());
			lf.setMax(lf.getCost() + 1);
		}

		lf.setLb(metier.getBidsOnProd(lf.getPr()));
		model.addAttribute("loginForm", lf);
		return "bid_on_prod";
	}

	@RequestMapping(value = "/showProduct")
	public String showProd(LoginForm lf, Model model,
			@RequestParam("id_prod") String id_prod) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) auth
				.getPrincipal();
		lf.setUser(metier.findUserByUsername(usr.getUsername()));
		lf.setLb(null);
		lf.setError(false);
		try {
			lf.setPr(metier.getProduct(Long.valueOf(id_prod)));
		} catch (Exception e) {
			lf.setError(true);
			return "bid_on_prod";
		}

		lf.setLb(metier.getBidsOnProd(lf.getPr()));

		// check if timeout
		lf.setTimeout(false);
		if (lf.getPr().getDateExp().compareTo(new Date()) < 0) {
			// ^ dateExp < currDate

			lf.setTimeout(true);

		}

		model.addAttribute("loginForm", lf);
		return "showProduct";
	}

}
