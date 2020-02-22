package Basic.Aautil;

import java.util.*;

public class PerfectNumber
{
	public static void main(String[] args) {
                
        for(int i=1;i<10000;i++){
            if (findPerfect(i)){
                System.out.println(i + " is perfect number");
            }
        }
        
      
	}
	
	public static boolean findPerfect(int num){
	    int count = 0;
	    for(int i=1;i<num;i++){
	        if ( num % i == 0){
	            count = count + i;
	        }
	    }
	    
	    if (num == count) return true;
	    
	    return false;
	}

}
