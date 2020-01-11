package Basic.Enum;

enum Singletton{//Since Enum instances are by default final in Java, it also provides safety against multiple instance.
	INSTANCE;
	
	public void show(){
		System.out.println("Singleton using enum in Java");
	}
}

public class ThreadSafeSingleton {

	public static void main(String[] args){
		//You can access this Singleton as Singleton.INSTANCE and call any method like below
		Singletton.INSTANCE.show();
	}
}
