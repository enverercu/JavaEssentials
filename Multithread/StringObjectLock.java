package Basic.Multithread;

public class StringObjectLock {

	private static final String LOCK = "lock"; //not recommended. string pool. 
	private static final Object OBJ_LOCK = new Object(); //better. MUST BE FINAL

	public void process(){
		synchronized(OBJ_LOCK){
			
		}
	}
	
}
