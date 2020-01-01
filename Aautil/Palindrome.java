package Basic.Aautil;

import java.util.*;

public class Palindrome {

	public static void main(String[] args){
		
	}
	
	public static boolean isPalindrome(String s1){
		
		StringBuilder sBuilder = new StringBuilder();
		
		char[] charArray = s1.toCharArray();
		
		for(int i = charArray.length-1;i>=0;i--){
			sBuilder.append(charArray[i]);
		}
		
		String s1Reverse = sBuilder.toString();
		
		return s1Reverse.equals(s1);
		
		
	}
}
