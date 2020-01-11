package Basic.Multithread;

//Do not synchronize on the non-final field on synchronized block in Java. because the reference of the non-final field may change anytime and then different thread might synchronizing on different objects i.e. no synchronization at all

public class NonFinalFieldSync {

	private String lock = new String("lock");
	
	public void m1(){
		synchronized(lock){ 
			System.out.println("locking on :" + lock); 
		}
	}
	
	
	public static void main(String[] args){
		
	}
	
}
