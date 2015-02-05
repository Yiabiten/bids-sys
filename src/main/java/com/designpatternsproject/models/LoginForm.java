package com.designpatternsproject.models;

import java.util.List;

import com.designpatternsproject.entities.Bid;
import com.designpatternsproject.entities.Card;
import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.entities.User;

public class LoginForm {
	private String mail;
	private String password;
	private User user;
	private List<Card> lc;
	private List<Bid> lb;
	private List<Produit> lp;
	private List<User> lu;
	
	public List<User> getLu() {
		return lu;
	}

	public void setLu(List<User> lu) {
		this.lu = lu;
	}

	private Produit pr;
	private Long max;
	private Long cost;
	private boolean error;
	private boolean timeout;
	
	private String usr;
	private String prd;
	private String val;
	
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPrd() {
		return prd;
	}

	public void setPrd(String prd) {
		this.prd = prd;
	}

	private String idProd;
	private String prodName;
	private String minPrice;
	private String prodDesc;
	private String exp;

	private String prof;
	private String pwdAgain;
	private String first;
	private String last;

	public String getIdProd() {
		return idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public boolean isTimeout() {
		return timeout;
	}

	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Long getMax() {
		return max;
	}

	public void setMax(Long max) {
		this.max = max;
	}

	public Produit getPr() {
		return pr;
	}

	public void setPr(Produit pr) {
		this.pr = pr;
	}

	public List<Card> getLc() {
		return lc;
	}

	public void setLc(List<Card> lc) {
		this.lc = lc;
	}

	public List<Bid> getLb() {
		return lb;
	}

	public void setLb(List<Bid> lb) {
		this.lb = lb;
	}

	public List<Produit> getLp() {
		return lp;
	}

	public void setLp(List<Produit> lp) {
		this.lp = lp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public String getPwdAgain() {
		return pwdAgain;
	}

	public void setPwdAgain(String pwdAgain) {
		this.pwdAgain = pwdAgain;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

}
