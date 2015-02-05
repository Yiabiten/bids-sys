package test;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.designpatternsproject.entities.Card;
import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.entities.User;
import com.designpatternsproject.metier.IBidsMetier;
import com.designpatternsproject.metier.MetierImpl;

public class Test {

	public static void main(String[] args) throws Exception{
		

		/*	
			String original = new Scanner(System.in).next();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(original.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}

			System.out.println("original:" + original);
			System.out.println("digested(hex):" + sb.toString());
		
		*/
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IBidsMetier m = (IBidsMetier) ctx.getBean("metier");

		System.out.println("======begin=======");

		
		
		User u = m.getUser(1L);
		
		User x = new User("Super", "User", "06XXOOXXOO",
				"su@mail.me", "password");
		x.getRoles().add(m.getRole("Admin"));
		m.addUser(x);
		

		
		/*
		
		//********************************************
		
		
		x = new User("Youness", "IABITEN", "06XXOOXXOO", "yiabiten@mail.me",
				"password");
		m.addUser(x);
		
		
		x = new User("Amine", "RHANEMI", "06XXOOXXOO", "rhanemi@gmail.com",
				"password");
		m.addUser(x);
		

		/*
		d = new Date("03/03/2015");

		p = new Produit("Product1", "usé", "", 550L, d);
		p.setUser(x);
		p = m.addProduit(p);

		d = new Date("04/05/2015");
		Produit pp = new Produit("Product2", "New", "", 199L, d);
		pp.setUser(x);
		pp = m.addProduit(pp);

		
		Card c = new Card("VISA", "Youness Yabiten", d, 12345678901L);

		System.out.println("Adding card to usr:" + m.addCard(x, c));

		
		System.out.println("-----------------------------\n+"
				 		+  "------------My Projects------+"
				 		+  "-----------------------------");
		List l = m.getPrdoductsByUser(x);
		for (Object o : l) {
			System.out.println(((Produit) o).getName() + " : $"
					+ ((Produit) o).getPrixMin());
		}
		System.out.println("-----------------------------\n+"
				 		+  "------------ALL--------------+"
				 		+  "-----------------------------");
		l=m.getAllPrdoducts();
		for (Object o : l) {
			System.out.println(((Produit) o).getName() + " : $"
					+ ((Produit) o).getPrixMin());
		}
		System.out.println("-----------------------------\n+"
						+  "---------OTHERS--------------+"
						 + "-----------------------------");
		
		l=m.getOthersProduct(x);
		for (Object o : l) {
			p=(Produit) o;
			System.out.println(((Produit) o).getName() + " : $"
					+ ((Produit) o).getPrixMin());
		}
		
		
		System.out.println("biding"+m.bid(p, 500L, x));
		System.out.println("biding"+m.bid(p, 1500L, x));
		
		System.out.println(m.getCountBidsUserOnProd(x, p));
		*/
		
		
	}

}
