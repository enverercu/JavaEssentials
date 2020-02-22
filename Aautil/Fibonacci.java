package Basic.Aautil;


public class Fibonacci
{
	public static void main(String[] args) {
    	 
    	 System.out.println(0);
	     System.out.println(1);
	     fibonacci(8);
    	 
	}
	
	static int i = 0;
	static int j = 1;
	static int k = 0;
	
	
	
	public static void fibonacci(int num){
	    
	    if ( num > 0 ){
	        k = i + j;
	        System.out.println(k);
	        i = j;
	        j = k;
	        fibonacci(num-1);
	    }
	    
	}

}

