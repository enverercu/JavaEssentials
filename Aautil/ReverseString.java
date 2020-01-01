package Basic.Aautil;

public class ReverseString {

	public static void main(String[] args){
		
	}
	
	public static String reverse(String input){
		
		StringBuilder stringBuilder = new StringBuilder(input);
		
		return stringBuilder.reverse().toString();
	}
	
	public static String reverseString(String input){
		
		char[] charArray  = input.toCharArray();
		
		StringBuilder strBuilder = new StringBuilder();
		
		for (int i = charArray.length-1; i>=0; i--){
			
			strBuilder.append(charArray[i]);
		}
		
		return strBuilder.toString();
		
	}
}

