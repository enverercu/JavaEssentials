package Basic.Multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{

	private int id;
	
	public Processor(int id){
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting..." + id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed..." + id);
	}
	
}

public class AADemoThreadPool {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);//2 thread tüm tasklarý çalýþtýrmaya baþlar.
		
		for (int i=0; i<5; i++){
			executor.submit(new Processor(i));//5 tasks submit ediyoruz.
		}
		
		executor.shutdown();//manager servise artýk submit olmayacaksa durdurmalýyýz.
		//hemen shutdown yapmaz 5 taskýn bitmesini bekler.
		
		System.out.println("All task submitted.");
		
		try {
			executor.awaitTermination(10, TimeUnit.SECONDS); // 10 saniye bekler, tasklar bitmezse akýþa devam eder.
		} catch (InterruptedException e) {
		} 
		
		System.out.println("All tasks completed.");
	}

}
