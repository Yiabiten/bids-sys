package test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.designpatternsproject.entities.Produit;
import com.designpatternsproject.metier.IBidsMetier;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IBidsMetier m =(IBidsMetier) ctx.getBean("metier");
		
		Produit p = new Produit("Prod1", "mzyane", "", 100L, new Date());
		System.out.println("======begin=======");
		m.addProduit(p);
		
	}

}
