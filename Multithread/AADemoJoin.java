package Basic.Multithread;

//1 - C extends Thread --> C c = new C(); c.start();
//2 - C implements Runnable --> Thread t1 = new Thread(new C());
//3 - Thread t1 = new Thread(new Runnable(){}); t1.start();


public class AADemoJoin {

	private int count = 0; //no need to make volatile because of synchronized method
	
	public synchronized void increment(){ 
		count++;
	}
	
	public static void main(String[] args) {
		
		AADemoJoin demo = new AADemoJoin();
		demo.doWork();
	}
	
	public void doWork(){
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					increment();
				}
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					increment();
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The count is " + count);
	}

}
