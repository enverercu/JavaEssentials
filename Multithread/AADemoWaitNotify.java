package Basic.Multithread;

import java.util.*;

class Processors{
	
	public void produce() throws InterruptedException{
		synchronized(this){ //Processors object itself
			System.out.println("Producer thread running...");
			wait();//here this synchronized code block loose control. gives the control to the another "this" lock
				   //for take control again, a thread which locks "this" should call notify method.	
			System.out.println("Resumed.");
		} 
	}
	
	public void consume() throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
			
		synchronized(this){ //IMPORTANT! it must lock the same object.
			System.out.println("Waiting for a return key");
			scanner.nextLine();//waits for the return key
			System.out.println("Return key pressed.");
			notify();//gives the control to the waiting "this" lock block
			Thread.sleep(5000);//!!!notify method call edilse bile lock block bitmeden diger thread uyanamaz.!!!
		}
	}
	
	
	private Object lock = new Object(); 	
	//synchronized(lock) --> lock.wait() --> lock.notify() !!MUST BE ON SAME OBJECT
	public void produceX() throws InterruptedException{
		synchronized(lock){ //IMPORTANT! it must lock the same object.
			System.out.println("Producer thread running...");
			lock.wait();//wait() and notify() is the main methods of Object class like toString() hashCode() equals()
			System.out.println("Resumed.");
		} 
	}
	
	public void consumeX() throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
			
		synchronized(lock){ //IMPORTANT! it must lock the same object.
			System.out.println("Waiting for a return key");
			scanner.nextLine();
			System.out.println("Return key pressed.");
			lock.notify();
			Thread.sleep(5000);
		}
	}
	
}

public class AADemoWaitNotify {

	public static void main(String[] args) throws InterruptedException {
		
		final Processors processor = new Processors();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					processor.produceX();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					processor.consumeX();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
				
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
			
	}

}
