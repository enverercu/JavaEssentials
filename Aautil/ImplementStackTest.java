package Basic.Aautil;

import org.junit.*;
import static org.junit.Assert.*;

public class ImplementStackTest {

	@Test
	public void m1(){
		ArrayStack<String> arrStack = new ArrayStack<>();
		assertTrue(arrStack.isEmpty());
		arrStack.push("1");
		assertEquals(1,arrStack.size());
		arrStack.pop();
		assertTrue(arrStack.isEmpty());
	}
	
	@Test
	public void m2(){
		ArrayStack<String> arrStack = new ArrayStack<>();
		arrStack.push("one");
		assertEquals("one",arrStack.pop());
	}
	
	@Test
	public void m3(){
		ArrayStack<String> arrStack = new ArrayStack<>();
		arrStack.push("one");
		assertTrue(arrStack.contains("one"));
	}
	
	@Test
	public void m4(){
		ArrayStack<String> arrStack = new ArrayStack<>();
		arrStack.push("one");
		arrStack.clear();
		assertEquals(0,arrStack.size());
	}
}
