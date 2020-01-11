package Basic.Multithread.Synchronization;
//Like one person is preparing food (Producer) while other one is serving food (Consumer)
//Producer which is the person preparing food will wait if table is full and Consumer (Person who is serving food) will wait if table is empty
//table is a shared object here

//On Java library "Executor framework" itself implement Producer Consumer design pattern be separating responsibility of addition and execution of task

//Producer Consumer Pattern simple development. you can Code Producer and Consumer independently and Concurrently, they just need to know shared object.

//Producer and Consumer can work with different speed. There is no risk of Consumer consuming half-baked item

//classical way is using "wait and notify" method to communicate between Producer and Consumer thread and blocking each of them on individual condition like full queue and empty queue

//BlockingQueue provides this control implicitly by introducing blocking methods put() and take(). Now you don't require to use wait and notify to communicate between Producer and Consumer.

//BlockingQueue put() method will block if Queue is full in case of Bounded Queue and take() will block if Queue is empty.

//Developer doesn't need to write confusing and critical piece of wait-notify code to implement communication

import java.util.concurrent.*;

class Producer implements Runnable{
	
	private final BlockingQueue<Integer> sharedQueue;
	
	public Producer(BlockingQueue sharedQueue){
		this.sharedQueue = sharedQueue;
	}
	
	@Override
	public void run(){
		for (int i=0; i<10;i++){
			try{
				sharedQueue.put(i);
				System.out.println("Produced:" + i);
				Thread.sleep(100);
				
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	
	private final BlockingQueue<Integer> sharedQueue;
	
	public Consumer(BlockingQueue sharedQueue){
		this.sharedQueue = sharedQueue;
	}
	
	@Override
	public void run(){
		while(true){
			try{
				int i = sharedQueue.take();
				System.out.println("Consumed:" + i);
				Thread.sleep(100);				
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

public class ProducerConsumerPattern {



	public static void main(String[] args) {
		
		//ArrayBlockingQueue : always bounded --> array --> contiguous --> memory not efficient
		//LinkedBlockingQueue : unbounded --> linked nodes
		
		//So in case you need an unbounded blocking queue, LinkedBlockingQueue used as a BlockingQueue

		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
		
		new Thread(new Producer(sharedQueue)).start();
		new Thread(new Consumer(sharedQueue)).start();
	}

}
