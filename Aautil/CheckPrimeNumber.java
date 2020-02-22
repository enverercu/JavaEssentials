package Basic.Aautil;

import java.util.*;

public class CheckPrimeNumber {
	
	public static void main(String[] args) {
	
		//Prime number is a number that is greater than 1 and divided by 1 or itself only. 
		//In other words, prime numbers can't be divided by other numbers than itself or 1. 
		//For example 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.
		
		System.out.println(isPrimeNumber(6));
	}
	
	public static boolean isPrimeNumber(int number){
		
		boolean flag = true;
		
		if (number < 0 || number == 0 || number == 1){
			return false;
		}
		
		if (number == 2 || number == 3){
			return true;
		}
		
		for (int i=2;i<number;i++){
			if (number%i == 0 ){
				flag = false;
				break;
			}
		}
		
		if (flag){
			System.out.println(number + " is a prime number");
		}
		else
		{
			System.out.println(number + " is NOT a prime number");
		}
		
		return flag;
	}

}
