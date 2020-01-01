package Basic.EagerLazyLoading;

public class SingletonEagerLoading {

	private static SingletonEagerLoading instance = new SingletonEagerLoading();//early initialization
	
	private SingletonEagerLoading(){
		
	}
	
	public SingletonEagerLoading getInstance(){
		return instance;
	}
}
