package Basic.Autoboxing;

import java.util.*;

//Autoboxing: Converting a "primitive" value into an object of the corresponding "wrapper class" is called autoboxing. 
//For example, converting int to Integer class.
//Java compiler applies autoboxing when a primitive value is

//Passed as a parameter to a method that expects an object of the corresponding wrapper class.
//Assigned to a variable of the corresponding wrapper class.

//Unboxing: Converting an object of a wrapper type to its corresponding primitive value is called unboxing. 
//For example conversion of Integer to int
//The Java compiler applies unboxing when an object of a wrapper class is

//Passed as a parameter to a method that expects a value of the corresponding primitive type.
//Assigned to a variable of the corresponding primitive type.


public class AATest {

	public static void main(String[] args){
		
		// creating an Integer Object 
        // with value 10. 
		Integer i = new Integer(10);
		
		//unboxing the Object
		int i1 = i;
		
		System.out.println("Value of i: " + i); 
        System.out.println("Value of i1: " + i1); 
        
        //Autoboxing of char
        Character c = 'a'; //Normalde Character c = new Character('a');
               
        //Auto unboxing of Character
        char ch = c;
        
        System.out.println("Value of c: " + c); 
        System.out.println("Value of ch: " + ch);
        
        
        //COLLECTIONS
        /* Here we are creating a list 
        of elements of Integer type. 
        adding the int primitives type values */
        List<Integer> list = new ArrayList<Integer>();
        for(int j=0; j<10; j++){
        	list.add(j);//auto-boxing : java compiler create Integer wrapper Object from primitive int i and adds it to the list
        } 
        
        //Java þuna çevirir.
        //list.add(Integer.valueOf(i));
        
	}
}
