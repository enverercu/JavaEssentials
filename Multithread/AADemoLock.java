package Basic.Multithread;

import java.util.*;

class Worker{
	
	private Random random = new Random();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public /*synchronized*/ void stageOne(){ //LOCK THE WHOLE OBJECT AND STAGETWO WAITS STAGEONE
		
		synchronized(lock1){ //stageone waits only stageone
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	
	}
	
	public /*synchronized*/ void stageTwo(){
		
		synchronized(lock2){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	
	public void process(){
		for(int i=0; i<1000; i++){
			stageOne();
			stageTwo();
		}
	}
	
	public void main(){
		System.out.println("Starting...");
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				process();
			}		
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				process();
			}	
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();//waits for t1 end
			t2.join();//waits for t2 end
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken..." + (end-start));
		
		System.out.println("List 1:" + list1.size() + " List 2:" + list2.size());
	}
}
public class AADemoLock {

	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.main();

	}

}
