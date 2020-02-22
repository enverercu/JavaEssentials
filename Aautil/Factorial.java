package Basic.Aautil;


public class Factorial
{
	public static void main(String[] args) {
    	
    	int x = 6;
        
        System.out.println(factorial(x));
	}
	
	public static int factorial(int num){
	    if (num == 0){
	        return 1;
	    }
	    
	    return num * factorial(num-1);
	}

}
