package Basic.Multithread;

//static synchronized method locked on "class object" lock 
//and nonstatic synchronized method locks on "current object (this)"


public class Counter {

	public static int count = 0;
	
	public static synchronized int getCount(){ //static locks class object
		//return this.count; error
		return count;
	}
	
	public synchronized void setCount(int count){ //locks current object "this". tehlikeli
		this.count = count;
	}
	
	//In this example of Java, the synchronization code is not properly synchronized because both getCount() and setCount() are not getting locked on the same object and can run in parallel which may result in the incorrect count
	//Here getCount() will lock in Counter.class object while setCount() will lock on current object (this).
	//To make this code properly synchronized in Java you need to either make both method static or nonstatic or use java synchronized block instead of java synchronized method
	
}
