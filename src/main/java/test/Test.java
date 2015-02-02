package test;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.designpatternsproject.entities.Card;
import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.entities.User;
import com.designpatternsproject.metier.IBidsMetier;

public class Test {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		IBidsMetier m = (IBidsMetier) ctx.getBean("metier");

		System.out.println("======begin=======");

		//********************************************
		User x = new User("jhdgsf", "sdfkuzd", "06XXOOXXOO",
				"qsdqsdten@mail.me", "pwd");
		m.addUser(x);

		Date d = new Date("07/07/2015");

		Produit p = new Produit("Product9", "makaynch", "", 10L, d);
		p.setUser(x);
		p = m.addProduit(p);
		//********************************************
		
		x = new User("Youness", "IABITEN", "06XXOOXXOO", "yiabiten@mail.me",
				"password");
		m.addUser(x);

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
		
		
		

	}

}
