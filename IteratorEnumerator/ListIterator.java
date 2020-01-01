package Basic.IteratorEnumerator;

import java.util.*;

public class ListIterator {

	public static void main(String[] args){
		
		List<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add("B");
		
		java.util.ListIterator iter =  aList.listIterator();
		
		while (iter.hasNext()){
			System.out.print(iter.next() + " ");
		}
		
		System.out.println();
		
		while (iter.hasPrevious()){
			System.out.print(iter.previous() + " ");
		}
	}
}
