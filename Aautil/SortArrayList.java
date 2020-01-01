package Basic.Aautil;

import java.util.*;
import java.util.Map.*;
import java.util.Set.*;

import org.junit.*;
import static org.junit.Assert.*;

public class SortArrayList {

	public static ArrayList<String> unSortedList;
	
	@BeforeClass
	public static void beforeClass(){
		unSortedList = new ArrayList<String>();
	}
	
	@Before
	public void before(){
		unSortedList.clear();
		unSortedList.add("Java");
		unSortedList.add("C++");
		unSortedList.add("J2EE");
	
	}
	
	@After
	public void after(){
		System.out.println("*********");
	}
	
	@Test
	public void m1(){
		Collections.sort(unSortedList);
		for(String str:unSortedList){
			System.out.println(str);
		}
	}
	
	@Test
	public void m2(){
		Collections.sort(unSortedList, Collections.reverseOrder());
		for (String str:unSortedList){
			System.out.println(str);
		}
	}
	
}
