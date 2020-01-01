package Basic.Aautil;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class AnagramTest {

	@Test
	public void m1(){
		assertTrue(Anagram.isAnagram("aabbcc", "bbccaa"));
		assertTrue(Anagram.isAnagram("ab c", "b c ?a"));
	}
	
	@Test
	public void m2(){
		assertTrue(Anagram.issAnagram("aabbcc", "bbccaa"));
	}
}
