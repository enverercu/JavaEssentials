package Basic.Aautil;

public class PalindromeNumber {

	public static void main(String[] args) {
		

	}
	
	public static Integer findPalindrome(Integer number){
		
		if (number <= 0 || number > Integer.MAX_VALUE){
			return -1;
		}
		
		Integer number1 = number;
		
		StringBuilder sb = new StringBuilder();
		
//		1234 123 4
//		123  12  3
//		12   1   2
//		1    0   1
		
		int dividend = 0;
		int remainder = 0;
		while (number>0){
			dividend = number / 10;
			remainder = number % 10;
			sb.append(remainder);
			number = dividend;
		}
		
		Integer result = Integer.valueOf(sb.toString());
		
		System.out.println(number1 + "-" + result);
		
		return result;
	}

}
