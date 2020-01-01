package Basic.Aautil;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class DublicateCharactersTest {

	@Test
	public void m1(){
		
		assertEquals(Collections.emptyMap(),DublicateCharactersInString.find("abcdef"));
		assertEquals(Collections.emptyMap(),DublicateCharactersInString.find("aaabbcc"));
		
	}
}
