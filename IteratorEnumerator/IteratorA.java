package Basic.IteratorEnumerator;

import java.util.*;

public class IteratorA {
	
	public static void main(String[] args){
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add("B");
		aList.add("C");
		aList.add("D");
		aList.add("C");
		
		for(String s:aList){
			System.out.print(s + " ");
		}
		
		Iterator<String> iter = aList.iterator();	
		while(iter.hasNext()){
			String s = iter.next();
			if (s.equals(String.valueOf("C"))){
				iter.remove();
			}
		}
		
		System.out.println();
		
		Iterator<String> newIter = aList.iterator();
		while (newIter.hasNext()){
			System.out.print(newIter.next() + " ");
		}
	
	}

}
