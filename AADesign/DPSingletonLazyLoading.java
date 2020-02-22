package Basic.AADesign;

public class DPSingletonLazyLoading {

	private static volatile DPSingletonLazyLoading instance; //use volatile to make singleton thread-safe
	
	private DPSingletonLazyLoading(){
		throw new RuntimeException();//You can still access private constructor by reflection and calling setAccessible(true)
	}
	
	//DOUBLE CHECK LOCKING THREAD SAFE SINGLETON
	public DPSingletonLazyLoading getInstance(){ //not synchronize whole method. Instance oluþmuþ olsa bile sürekli burada bekleme olur.
		if (instance == null){//check
			synchronized(DPSingletonLazyLoading.class){ //critical section code NOT SYNCRONIZED(this) !!
				if (instance == null){ //double check
					instance = new DPSingletonLazyLoading();//We are creating instance lazily at the time of the first request comes.
				}
			}
		}
		
		return instance;
	}
}
