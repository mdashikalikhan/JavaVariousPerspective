package om.orbi.test;

import java.util.Date;

public class FDateTest {

	public static void main(String[] args) {
		FDate date1 = new FDate(2022,2,30);
		System.out.println((date1.getMonth()+1)%3);
		System.out.println(date1.getMonth());
		System.out.println(date1);
	}

}
