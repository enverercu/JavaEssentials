package Basic.Enum;

import org.junit.*;
import static org.junit.Assert.*;

public class EnummTest {

	@Test
	public void m1(){
		assertEquals(Kurrency.HUNDRED.value,Kurrency.HUNDRED.getValue());
	}
}
