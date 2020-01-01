package Basic.Final;

public class finall {

	static final int CAPACITY = 4; 
    
    public static void main(String args[]) 
    { 
        // re-assigning final variable 
        // will throw compile-time error 
        //CAPACITY = 5; 
        
        // local final variable 
        final int i; 
        i = 20;  
        System.out.println(i); 
    } 
}
