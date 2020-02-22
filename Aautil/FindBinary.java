package Basic.Aautil;

import java.util.*;

public class FindBinary
{
	public static void main(String[] args) {
        
        for(int i=1;i<10000;i++){
            if (findBinary(i)){
                System.out.println(i + " is binary number");
            }
        }
      
	}
	
	public static boolean findBinary(int num){
	    
	    while (num > 0) {
	        int dividend = num / 10;
	        int remainder = num % 10;
	        if (remainder > 1){
	            return false;
	        }
	        num = dividend;
	    }
	    
	    return true;
	    
	}

}

