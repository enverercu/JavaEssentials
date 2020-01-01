package Basic.Aautil;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class CompareArrays {

	int[] even = {2,4,6,8};
	int[] evenToo = {2,4,6,8};
	int[] odd  = {1,3,5,7};
	
	String[] numbers = {"one","two"};
	String[] digits = {"one","two"};
	
	char[][] cMulti = {{'A','B'},{'C','D'}};
	char[][] ccMulti = {{'A','B'},{'C','D'}};
	
	@Test
	public void m1(){
		boolean b1 = Arrays.equals(even, evenToo);
		assertTrue(b1);
	}
	
	@Test
	public void m2(){
		boolean b2 = Arrays.equals(even, odd);
		assertTrue(b2);
	}
	
	@Test
	public void m3(){
		boolean b3 = Arrays.equals(numbers,digits);
		assertTrue(b3);
	}
	
	@Test
	public void m4(){
		boolean b4 = Arrays.equals(cMulti, ccMulti);//false
		assertTrue(b4);
	}
	
	@Test
	public void m5(){
		boolean b5 = Arrays.deepEquals(cMulti, ccMulti);
		assertTrue(b5);
	}
	
}
