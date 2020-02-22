package Basic.Reflection;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.lang.reflect.*;

class Person{
	private int id;
	private String name;
	private double salary;
	
	public Person(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public double getSalary(int multiply){
		return this.salary * multiply;
	}
}

public class AAATest {

	
	@BeforeClass
	public static void m1(){
		
	}
	
	@Before
	public void m2(){
		
	}
	
	@Test
	public void m3(){
		
		Person p = new Person(1,"andy",300.0f);	
		Class person = p.getClass();
		
		try{	
			Method m = person.getMethod("getSalary", int.class);
			double salary = (double)m.invoke(p, 2);
			assertEquals(salary,600.0d,0); //delta because double
			System.out.println("Salary:" + salary);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	@Test
	public void m4(){
		
	}
	
}
