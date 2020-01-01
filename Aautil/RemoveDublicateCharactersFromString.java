package Basic.Aautil;

import java.util.*;

public class RemoveDublicateCharactersFromString {

	public static void main(String[] args) {
		
		//just keep in mind that Set doesn't preserver insertion order which is guaranteed by List
		//So when you convert ArrayList to HashSet all duplicates elements will be removed 
		//but insertion order will be lost.
		//but don't worry there is another way of removing duplicates from ArrayList without losing order of elements, 
		//for that instead of HashSet we need to use LinkedHashSet, Which guarantees insertion order.


	}
	
	public static String removeDublicates(String input){
		
		if (input == null || input.isEmpty()){
			return "";
		}
		
		//bananas -> bans
		
		char[] charArray = input.replaceAll("[^a-zA-Z]", "").toCharArray();
		StringBuilder sb = new StringBuilder();
		
		LinkedHashSet<Character> linked = new LinkedHashSet<Character>();		
		for(char c:charArray){
			linked.add(c);
		}
		
		for (char c:linked){
			sb.append(c);
		}
		
		System.out.println(input);
		System.out.println(sb.toString());
		
		return sb.toString();
		
		
		
		
	}

}
