package Basic.Aautil;

class Wrapper<T>{//parameterized class. T means any type.
	private T item;
	
	public T getItem(){ //return any type
		return this.item;
	}
	
	public void setItem(T item){ //accepts any type
		this.item = item;
	}
	
	public static <T> T wrap (T item){ //useful in static methods. return :  "<T> T"		
		return item;
	}
}

public class GenericClass {

	public static void main(String[] args) {

		//Parameterized classes offer compile time type verification
		//If you use Generic parametrized method or class you don't need to cast into a specific type
		
		//Wrapper can wrap any item
		
		Wrapper<String> stringWrapper = new Wrapper<String>();
		stringWrapper.setItem("123");
		System.out.println(stringWrapper.getItem());
		
		Wrapper<Double> doubleWrapper = new Wrapper<Double>();
		doubleWrapper.setItem(1.25d);
		System.out.println(doubleWrapper.getItem());
		
		char c = Wrapper.wrap('a');
		System.out.println(c);
		
	}
	
	

}
