package Basic.Multithread.Synchronization;

import java.util.*;
import java.util.concurrent.*;

class Worker implements Runnable{
	
	private CountDownLatch latch;
	private String name;
	
	public Worker(CountDownLatch latch, String name){
		
		this.latch = latch;
		this.name = name;
	}
	
	@Override
	public void run(){
		
		try{
			
			Thread.sleep(1000);
			latch.countDown();
			System.out.println(name + " has processed.");
			
		}
		catch(InterruptedException e){
			 e.printStackTrace();
		}
		
	}
}

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException{
		
		// Let us create task that is going to wait for four threads before it starts
		CountDownLatch latch = new CountDownLatch(10);
		
		for(int i = 0; i<10; i++){
			
			new Thread(new Worker(latch,String.valueOf(i))).start();
		}
		
		// The main task waits for 100 threads
		latch.await();
		
		// Main thread has started
		System.out.println(Thread.currentThread().getName() + " has finished.");

	}

}

