package Basic.EqualityOperator;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestClass {

	//Any time you create a new String object using "String literal", JVM first checks String pool and if an object with similar content available, than it returns that and doesn't create a new object. 
	//JVM doesn't perform String pool check if you create object using new operator.

	String name = "Scala"; //1st String object
	String name_1 = "Scala"; //same object referenced by name variable
	String name_2 = new String("Scala"); //different String object
	
	String personalLoan = new String("cheap personal loans");
	String homeLoan = new String("cheap personal loans");


	@Test
	public void m1(){
		assertTrue(name==name_1);
	}
	
	@Test
	public void m2(){
		assertTrue(name==name_2);
	}
	
	@Test
	public void m3(){
		
		System.out.println(personalLoan==homeLoan);//since two strings are different object result should be false
		System.out.println(personalLoan.equals(homeLoan));//since strings contains same content , equals() should return true
		personalLoan = homeLoan;
		System.out.println(personalLoan==homeLoan);//since both homeLoan and personalLoan reference variable are pointing to same object
	
	}
	
}
