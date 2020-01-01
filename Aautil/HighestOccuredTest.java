package Basic.Aautil;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class HighestOccuredTest {

	@Test
	public void m1(){
		assertEquals(Collections.emptyMap(),HighestOccuredCharacterInString.find(""));
	}
	
	@Test
	public void m2(){
		assertEquals(Collections.emptyMap(),HighestOccuredCharacterInString.find("aaaaabbccdd"));
	}
}
