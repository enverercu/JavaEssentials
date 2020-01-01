package Basic.Aautil;

public class CountOfCharacterInString {

	public static void main(String[] args){
		
	}
	
	public static int findCount(String string, char ch){
		
		char[] charArray = string.toCharArray();
		int count = 0;
		
		for (char c:charArray){
			if (c == ch){
				count++;
			}
		}
		
		System.out.println(ch + "-" + count);
		
		return count;
	}
}
