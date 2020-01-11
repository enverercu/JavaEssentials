package Basic.Enum;

enum DaysOfWeekEnum {
    SUNDAY,
    MONDAY,
    TUESDAY, 
    WEDNESDAY, 
    THURSDAY, 
    FRIDAY, 
    SATURDAY
};

class Currencys{
	public static final int PENNY = 1; //99 : it’s not type-safe; you can assign any valid int value to currency e.g. 99 though there is no coin to represent that value.
	public static final int NICKLE = 5; //into a method we must input 5 instead of NICKLE and it may be wrong.
	public static final int DIME = 10;
	public static final int QUARTER = 25;
}

enum Currency { 
	PENNY, //implicity static and final
	NICKLE, 
	DIME, 
	QUARTER
};

//ENUM HERHANGI BIR CLASS I EXTEND VEYA IMPLEMENT EDEBILIR FAKAT KENDISI EXTEND EDILEMEZ! FINAL DIR.
//Enum in Java can implement the interface and override any method like normal class 
//It’s also worth noting that Enum in java implicitly implements both "Serializable" and "Comparable" interface
enum Kurrency implements Runnable{	
	HUNDRED(100){
		@Override
		public String color(){//since every coin will have the different color we made the color() method abstract and let each instance of Enum to define  their own color. You can get color of any coin by just calling the color() method
			return "copper";
		}
		@Override
		public String doOperation(){
			return "HUNDRED";
		}
	},
	FIVEHUNDRED(500){
		@Override
		public String color(){
			return "bronze";
		}
	};
	public final int value;//need to define a member variable
	
	private Kurrency(int value){ // You can specify values of enum constants at the creation time."private constructor".
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	@Override
	public void run(){
		System.out.println("Enum in Java can implement Runnable");
	}
	
	public abstract String color();//You can define abstract methods inside Enum in Java and can also provide a different implementation for different instances of enum in java.
	
	public String doOperation(){ //you can override in enum constants but its not mandatory.
		return "Default";
	}
}

enum Operation{//final
	PLUS {
		@Override
		public double doOperation(double x, double y){ //like strategy pattern
			return x + y;
		}
	},
	MINUS {
		@Override
		public double doOperation(double x, double y){
			return x - y;
		}
	};
	
	abstract double doOperation(double x, double y);
}


public class Enumm {
	
	//Enum constants are implicitly "static and final" and you can not change their value once created. 
	//Enum in Java provides type-safety and can be used inside "switch statement" like int variables.

	//Enum in Java are reference types like class or interface and you can define constructor, 
	//methods and variables inside java Enum
	
	//IMPORTANT : Lazy loading...
	//An instance of Enum in Java is created when any Enum constants are first called or referenced in code.


	public static void main(String[] args) {
		
		for (DaysOfWeekEnum day : DaysOfWeekEnum.values()) { //values() returns array of Enum constants in the same order they have listed in Enum
		    System.out.println(day); 
		}
		
		Currency coin = Currency.PENNY;
		//coin = 1; COMPILATION ERROR. TYPE SAFETY. very good, you cant set wrong value.

		Kurrency c = Kurrency.HUNDRED;
		System.out.println(c + "-" + c.getValue());		

		if ( c == Kurrency.HUNDRED ){//Since constants defined inside Enum in Java are final you can safely compare them using "==",
			System.out.println("equal");
		}
		
		Kurrency cc = Kurrency.FIVEHUNDRED;
		
		switch(cc){ //Enum in java can be used as an argument on switch statement and with "case:" 
					//like int,short or char primitive type and String.
			case HUNDRED:
				System.out.println("hundred");
				break;
			case FIVEHUNDRED:
				System.out.println("five hundred");
				break;
		}
		//You can not create an instance of enums by using new operator in Java because the constructor of Enum in Java can only be private and Enums constants can only be created inside Enums itself.
		//Kurrency k = new Kurrency();

		cc.run();
		
		for (Kurrency kk:Kurrency.values()){
			System.out.println(kk + "-" + kk.getValue() + "-" + kk.color());
		}
		
		System.out.println(Operation.PLUS.doOperation(2.5d, 5.9d));
		
	}

}
