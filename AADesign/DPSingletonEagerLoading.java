package Basic.AADesign;

public class DPSingletonEagerLoading {

	//creating Singleton static final instance during class loading
	private static final DPSingletonEagerLoading instance = new DPSingletonEagerLoading();//early initialization
	
	private DPSingletonEagerLoading(){

	}
	
	//creating thread safe singleton in Java using "static factory" method
	//getInstance() serves as static factory method.
	public static DPSingletonEagerLoading getInstance(){
		return instance;
	}
	
	public static void main(String[] args){
		DPSingletonEagerLoading s = DPSingletonEagerLoading.getInstance();
	}
}
