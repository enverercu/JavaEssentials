package Basic.Multithread;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {

	private int count = 0;
	private Lock lock = new ReentrantLock(); //bir thread lock yaptýðý sayý kadar unlock yapmalý yoksa lock acilmaz.
	private Condition cond = lock.newCondition(); //condition on lock object.
	
	public void increment(){
		for(int i=0; i<10000; i++){
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException{
		
		//lock.lock();
		//increment();
		//lock.unlock();
		
		lock.lock();
		
		System.out.println("Waiting...");
		
		cond.await();//like Object's wait() method.GIVES CONTROL TO OTHER THREAD.
		
		System.out.println("Woken up!");
		
		try{
			increment();
		}
		finally{
			lock.unlock(); //guarantees unlock what the exception is.
		}	
	}
	
	public void secondThread() throws InterruptedException{
		
		//lock.lock();
		//increment();
		//lock.unlock();
		
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");
		
		cond.signal();//wakes up the waiting thread.
		
		try{
			increment();
		}
		finally{
			lock.unlock(); //guarantees unlock what the exception is.
		}	
	}
	
	public void finished(){
		System.out.println("Count is:" + count);
	}
}

public class AADemoReEntrantLock {

	public static void main(String[] args) throws InterruptedException {
		
		final Runner runner = new Runner();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
				
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
			
		runner.finished();
	}
	
}
