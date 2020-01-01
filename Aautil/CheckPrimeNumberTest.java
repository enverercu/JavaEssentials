package Basic.Aautil;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class CheckPrimeNumberTest {

	private static Scanner scanner = new Scanner(System.in);
	private int number;
	
	@Before
	public void before(){
		boolean bad = true;
		do{
			try{
				System.out.println("Please enter a number:");
				number = scanner.nextInt();
				bad = false;
			}catch(Exception ex){
				System.out.println("Incorrect entry. Please input only a positive integer.");
	            scanner.nextLine();
			}
		}while(bad);
		
	}
	
	@Test
	public void m1(){		
		assertTrue(CheckPrimeNumber.isPrimeNumber(number));
	}
	
}
