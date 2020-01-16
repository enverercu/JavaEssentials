package Basic.Multithread;

import java.util.concurrent.*;

class Proccessor implements Runnable{
	private CountDownLatch latch;//no need to synchronized keyword, because countdownlatch class is threadsafe.
	
	public Proccessor(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void run(){
		System.out.println("Started");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		latch.countDown();//her thread iþini bitirince latch'i 1 düþürür.
	}
	
}

public class AADemoCountDownLatch {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<3;i++){
			executor.submit(new Proccessor(latch));
		}
		
		try {
			latch.await(); // latch'in 0 a inmesini bekler.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed");

	}

}
