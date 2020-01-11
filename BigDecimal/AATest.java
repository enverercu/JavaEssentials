package Basic.BigDecimal;

import java.math.*;

public class AATest {

	public static void main(String[] args) {

		double a = 0.02;
		double b = 0.03;
		
		double c = b - a; //0.009999999999999998
		
		System.out.println(c);
		
		BigDecimal d = new BigDecimal("0.02");
		BigDecimal e = new BigDecimal("0.03");
		
		BigDecimal f = e.subtract(d); //0.01  GOOD AT PRECISION AND MONETARY CALCULATIONS
		
		System.out.println(f);
	}

}
