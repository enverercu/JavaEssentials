package Basic.Aautil;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class FirstNonRepeatedTest {

	@Test
	public void m1(){
		System.out.println(FirstNonRepeatedCharacterInString.findFirstNonDublicate("aabbcd"));
		assertEquals('c',FirstNonRepeatedCharacterInString.findFirstNonDublicate("aabbcd"));
		assertEquals('c',FirstNonRepeatedCharacterInString.findFirstNonDublicate("abbccd"));
	}
}
