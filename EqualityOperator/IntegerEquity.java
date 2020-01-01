package Basic.EqualityOperator;

public class IntegerEquity {

	public static void main(String[] args){
		
		//JVM cache objects of some wrapper class Integer from -128 to 127 and "return same object" 
		//which if compare via “ ==” can return true but after this range this validity doesn't work

		Integer i1 = 260; 
		Integer i2 = 260; 
		if (i1 == i2) { 
			System.out.println("i1 and i2 is equal"); 
		} else { 
			System.out.println("i1 and i2 is not equal "); 
		}

		Integer i3 = 100; 
		Integer i4 = 100; 
		if (i3 == i4) { 
			System.out.println("i3 and i4 is equal"); 
		} else { 
			System.out.println("i3 and i4 is not equal "); 
		}
		
		//instead use equals() method to compare Integers in Java

		if (i1.equals(i2)) { 
			System.out.println("Eq:i1 and i2 is equal"); 
		} else { 
			System.out.println("Eq:i1 and i2 is not equal "); 
		}

	}
}
