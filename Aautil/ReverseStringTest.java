package Basic.Aautil;

import org.junit.*;
import static org.junit.Assert.*;

public class ReverseStringTest {

	@Test
	public void m1(){
		
		assertEquals("enver",ReverseString.reverse("revne"));
		assertEquals("enver",ReverseString.reverseString("revne"));
		assertEquals("enverr",ReverseString.reverse("revne"));
	}
	
	
}
