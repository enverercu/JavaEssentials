package Basic.AADesign;

import java.util.*;
import java.util.concurrent.*;

public class MTProducerConsumer {

	//Race condition in Java occurs in a multi-threaded environment when more than one thread try to access a shared resource (modify, write) at the same time. 
	//Since multiple threads try to race each other to finish executing a method thus the name race condition.
	
	//FIFO
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);//Bounded//add and remove items with first in first out.
	//no need to sychronized because blocking queue is threadsafe.
	
	public static void main(String[] args) throws InterruptedException{
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();//waits for t1 finish
		t2.join();
		
	}
	
	private static void producer() throws InterruptedException{
		Random random = new Random();
				
		while(true){
			queue.put(random.nextInt(100));//waits if the queue is full.
		} 
	}
	
	private static void consumer() throws InterruptedException{
		Random random = new Random();
		
		while(true){
			Thread.sleep(100);
			
			if (random.nextInt(10) % 2 == 0){
				Integer value = queue.take();//waits if the queue is empty.
				
				System.out.println("Taken value:" + value + " queue size is:" + queue.size());
			}
		}
	}
}
