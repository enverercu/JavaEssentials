package Basic.Multithread;

import java.util.concurrent.Semaphore;

class Shared{
	static int count;
	
	static{
		count = 0;
	}
}
class Increment extends Thread{
	private Semaphore sem;
	public Increment(Semaphore sem){
		this.sem = sem;
	}
	public void run(){
		
		try {
			sem.acquire();//Thread tries to acquire permit.If the semaphore’s count is greater than zero, then the thread acquires a permit, which causes the semaphore’s count to be decremented.
			
			for(int i=0; i < 5; i++) 
	        { 
	            Shared.count++; 
	            System.out.println("Shared count:" + Shared.count); 
	  
	            // Now, allowing a context switch -- if possible. 
	            // for thread B to execute 
	            Thread.sleep(1000); 
	        }
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sem.release();//Thread release the "permit".When the thread no longer needs an access to the shared resource, it releases the permit, which causes the semaphore’s count to be incremented.
	}
}
class Decrement implements Runnable{
	private Semaphore sem;
	public Decrement(Semaphore sem){
		this.sem = sem;
	}
	public void run(){
		
		try {
			sem.acquire();//the thread will be blocked until a permit can be acquired.
			
			for(int i=0; i < 5; i++) 
	        { 
	            Shared.count--; 
	            System.out.println("Shared count:" + Shared.count); 
	  
	            // Now, allowing a context switch -- if possible. 
	            // for thread B to execute 
	            Thread.sleep(1000); //NOT GIVE CONTROL TO OTHER THREAD UNTIL SEMAPHORE RELEASE THE PERMIT.
	        }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sem.release();//Thread release the "permit".
	}
}

public class AADemoSemaphore {

	private Semaphore sem = new Semaphore(1, true);//1:one thread allowed at a time;true:give permit in start order
	
	public void doWork() throws InterruptedException{
		Increment t1 = new Increment(sem);
		Thread t2 = new Thread(new Decrement(sem));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Completed. Shared count:" + Shared.count);
	}
	
	public static void main(String[] args) {
		AADemoSemaphore object = new AADemoSemaphore();
		try {
			object.doWork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
