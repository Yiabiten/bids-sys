package test;

import java.util.Calendar;
import java.util.Date;



public class DateTst {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d);
		Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, 24);
        d=cal.getTime();
         System.out.println(d);
	}

}
