package Basic.Aautil;

import org.junit.*;
import static org.junit.Assert.*;

public class CountOfCharactersTest {

	@Test
	public void m1(){
		
		assertEquals(0,CountOfCharacterInString.findCount("enver", 'e'));
	}
}
