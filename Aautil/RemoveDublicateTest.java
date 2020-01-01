package Basic.Aautil;

import org.junit.*;
import static org.junit.Assert.*;

public class RemoveDublicateTest {

	@Test
	public void m0(){
		assertEquals("bans",RemoveDublicateCharactersFromString.removeDublicates(""));
		assertEquals("bans",RemoveDublicateCharactersFromString.removeDublicates(null));
	}
	
	@Test
	public void m1(){
		assertEquals("bans",RemoveDublicateCharactersFromString.removeDublicates("b??a n__an **==09as"));
		assertEquals("bans",RemoveDublicateCharactersFromString.removeDublicates("bananas"));
	}
}
