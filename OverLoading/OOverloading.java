package Basic.OverLoading;

//Method Overloading is a Compile time polymorphism. 
//In method overloading, more than one method shares the same method name with different signature in the class. 
//In method overloading, return type can or can not be be same, but we must have to change the parameter because in java, 
//we can not achieve the method overloading by changing only the return type of the method.


//Method Overriding is a Run time polymorphism. 
//In method overriding, derived class provides the specific implementation of the method 
//that is already provided by the base class or parent class. 
//In method overriding, return type must be same or co-variant (return type may vary in same direction as the derived class).

class OOverloading{  
	   static int add(int a, int b){return a+b;}  
	   static int add(int a, int b, int c){return a+b+c;} //different parameters
	   static double add(double a, double b){return a+b;} //different return type and parameters
	 
	    public static void main(String args[]) {
	      System.out.println(add(4, 6));
	      System.out.println(add(4, 6, 7));
	      System.out.println(add(4.1d, 6d));
	    }
	} 


