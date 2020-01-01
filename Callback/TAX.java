package Basic.Callback;

import java.util.Scanner;

interface STAX{
	
	double calculateTax();
	
}

class TurkishTax implements STAX{
	
	public double calculateTax(){
		
		return 3000.0d;
		
	}
}

class KibrisTax implements STAX{
	
	public double calculateTax(){
		
		return 1000.0d;
	}
}

public class TAX {

	static double calculateTax(STAX t){
		
		double tax = t.calculateTax();
		
		return tax;
	}
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		
		//System.out.println("Please enter the country name : ");
		
		String country = "Basic.Callback."+ scanner.next();
		
		// The state name is then stored in an object c
		Class c = Class.forName(country);
		
		// Create the new object of the class whose name is in  c 
        // Stax interface reference is now referencing that new object
		STAX ref = (STAX)c.newInstance();
		
		double tax = calculateTax(ref);
		
		System.out.println("Tax is :" + tax);
	}
}
