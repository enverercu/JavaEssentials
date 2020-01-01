package Basic.EqualityOperator;

class A{
	public String as = "sample";
}

class B{
	
	public String bs = "sample";
}

public class Main {
	
	public static void main(String[] args){
		
		String s = "sample";
		String str = "sample";
		
		A a = new A();
		A aa = new A();
		B b = new B();
		
		if (s == str){
			System.out.println("s==str");//true because of constant pool of String.
		}
		else
		{
			System.out.println("s!=str");
		}
		
		if (s.equals(str)){
			System.out.println("equals");
		}
		else
		{
			System.out.println("not equal");
		}
		
		if (a==aa){
			System.out.println("same object");
		}
		else{
			System.out.println("not same object");
		}
		
		
		if (a.as==b.bs){
			System.out.println("different class instance but same");
			//farklý classlarda bile olsa ayný constant pool da tutulur, memory optimizasyonu için.
		}
		else{
			System.out.println("different class instance not same");
		}
		
	}

	
}
