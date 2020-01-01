package Basic.Aautil;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args){
		//By the way two String are called anagram, if they contains same characters but on different order
	}
	
	public static boolean isAnagram(String first, String second){
		
		if (first == null || first.isEmpty()){
			return false;
		}
		if (second == null || second.isEmpty()){
			return false;
		}
		
		char[] firstArr = first.replaceAll("[^a-zA-Z]", "").toCharArray();
		char[] secondArr = second.replaceAll("[^a-zA-Z]", "").toCharArray();
		
		Arrays.sort(firstArr);
		Arrays.sort(secondArr);
		
		return Arrays.equals(firstArr, secondArr);
		
	}
	
	public static boolean issAnagram(String first, String second){
		
		char[] firstArray = first.toCharArray();
		StringBuilder secondBuilder = new StringBuilder(second);
		
		for(char c:firstArray){
			int index = secondBuilder.indexOf(""+c);
			if (index == -1){
				return false;
			}
			else
			{
				secondBuilder.deleteCharAt(index);
			}
		}
		
		if (secondBuilder.length() == 0){
			return true;
		}
		else
		{
			return false;
		}
	}
}
