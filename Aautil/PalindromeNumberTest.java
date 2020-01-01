package Basic.Aautil;

import org.junit.*;
import static org.junit.Assert.*;

public class PalindromeNumberTest {

	
	@Test(expected=NullPointerException.class)
	public void m1(){
		assertEquals(Integer.valueOf(-1),PalindromeNumber.findPalindrome(null));
	}
	
	@Test
	public void m2(){
		assertEquals(Integer.valueOf(120021),PalindromeNumber.findPalindrome(120021));
	}
	
	@Test
	public void m3(){
		assertEquals(Integer.valueOf(12231),PalindromeNumber.findPalindrome(12231));
	}
	
	@Test
	public void m4(){
		assertEquals(Integer.valueOf(12231),PalindromeNumber.findPalindrome(-13123123));
	}
}
