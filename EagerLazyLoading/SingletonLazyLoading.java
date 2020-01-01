package Basic.EagerLazyLoading;

public class SingletonLazyLoading {

	private static SingletonLazyLoading instance;
	
	private SingletonLazyLoading(){
		
	}
	
	public SingletonLazyLoading getInstance(){
		instance = new SingletonLazyLoading();
		return instance;
	}
}
