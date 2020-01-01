package Basic.AsserEqualsAssertSame;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Objects;

		//assertEquals: Asserts that two objects are equal.
		//assertEquals: uses the equals() method, or if no equals() method was overridden, compares the reference between the 2 objects.
		//assertSame: Asserts that two objects refer to the same object.
		//assertSame: compares the reference between the 2 objects.

class A{
	private int i;
	public A(int i){
		this.i = i;
	}
}
class B{
	private int i;
	public B(int i){
		this.i = i;
	}
	@Override
	public boolean equals(Object o){
		//self check
		if (this==o) return true;
		//null check
		if (o==null) return false;
		//type check and cast
		if (this.getClass()!=o.getClass()){
			return false;
		}else{
			B b = (B)o;
			//field comparison
			if (this.i == b.i){
				return true;
			}
			else return false;
		}
	}
}

public class Main {

	@Test
	public void m1(){
		A a = new A(0);
		A aa = new A(0);
		
		assertEquals(a,aa);
	}
	
	@Test 
	public void m2(){
		A a = new A(0);
		A aa = new A(0);
		
		assertSame(a,aa);	
		
	}
	
	@Test
	public void m3(){
		
		B b = new B(0);
		B bb = new B(0);
		
		assertEquals(b,bb);
	}
	
	@Test
	public void m4(){
		B b = new B(0);
		B bb = new B(0);
		
		assertSame(b,bb);
	}
	
		
}
