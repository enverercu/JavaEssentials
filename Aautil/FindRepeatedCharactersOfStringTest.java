package Basic.Aautil;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class FindRepeatedCharactersOfStringTest {

	@Before
	public void before(){
		System.out.println("******");
	}
	
	@Test
	public void m1(){//null
		assertEquals(Collections.emptyMap(), FindRepeatedCharactersOfString.findDublicatedCharacters(null));
	}
	
	@Test
	public void m2(){//empty
		assertEquals(Collections.emptyMap(), FindRepeatedCharactersOfString.findDublicatedCharacters(""));
	}
	
	@Test
	public void m3(){
		assertEquals(Collections.emptyMap(), FindRepeatedCharactersOfString.findDublicatedCharacters("enverercuyilmaz"));
	}
	
	@Test
	public void m4(){
		assertEquals(Collections.emptyMap(), FindRepeatedCharactersOfString.findDublicatedCharacters("enver eer$$ercu yi??  lmaz"));
	}
}
