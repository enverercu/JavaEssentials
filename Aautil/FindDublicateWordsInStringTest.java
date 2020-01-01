package Basic.Aautil;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class FindDublicateWordsInStringTest {

	@Test
	public void m1(){//empty
		
		Set<String> output = FindDublicateWordsInString.dublicateWords("");
		assertEquals(Collections.emptySet(),output);
		
	}
	
	@Test
	public void m2(){//null
		Set<String> output = FindDublicateWordsInString.dublicateWords(null);
		assertEquals(Collections.emptySet(),output);
	}
	
	@Test
	public void m3(){//with dublicate
		Set<String> output = FindDublicateWordsInString.dublicateWords("one two three two one");
		System.out.println("output" + output);
		assertEquals(Collections.emptySet(),output);
	}
	
	@Test
	public void m4(){//without dublicate
		Set<String> output = FindDublicateWordsInString.dublicateWords("one two three");
		assertEquals(Collections.emptySet(), output);
	}
	
	@Test
	public void m5(){
		Set<String> output = FindDublicateWordsInString.dublicateWords("one _$$  two $$     three ?? *=");
		assertEquals(Collections.emptySet(), output);
	}
	
}
