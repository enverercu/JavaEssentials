package Basic.Aautil;

import java.util.*;

public class FindArmstrong
{
	public static void main(String[] args) {
        
        for(int i=1;i<10000;i++){
            if (findArmstrong(i)){
                System.out.println(i + " is armstrong number");
            }
        }
      
	}
	
	public static boolean findArmstrong(int num){
	    int num1 = num;
	    int sum = 0;
	    while (num > 0){
	        int dividend = num / 10;
	        int remainder = num % 10;
	        sum = sum + (int)(Math.pow(remainder,3));
	        num = dividend;
	    }
	    if (sum == num1){
	        return true;
	    }
	    
	    return false;
	}

}
