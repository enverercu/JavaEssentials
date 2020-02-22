package Basic.Reflection;

import java.util.*;
import java.lang.reflect.*;

public class AATest {

	public static void main(String[] args){
		
		System.out.println(Arrays.toString(getListInterfaces()));
		
		System.out.println(Arrays.toString(getListMethods()));
		
	}
	
	public static Class<?>[] getListInterfaces(){
		Class<List> list = List.class;
		return list.getInterfaces();
	}
	
	public static Method[] getListMethods(){
		Class<ArrayList> list = ArrayList.class;
		return list.getMethods();
	}
	
}
