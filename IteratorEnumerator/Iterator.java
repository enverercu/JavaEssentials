package Basic.IteratorEnumerator;

import java.util.*;

public class Iterator {
	
	public static void main(String[] args){
		
		List<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add("B");
		
		java.util.Iterator<String> iter = aList.iterator();
		
		while (iter.hasNext()){
			System.out.println(iter.next());
		}
	
	}

}
