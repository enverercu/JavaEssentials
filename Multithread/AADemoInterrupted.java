package Basic.Multithread;

public class AADemoInterrupted {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				
				for(int i=0; i<1E9;i++){
					try {
						Thread.sleep(100);
						System.out.println("Running...");
					} catch (InterruptedException e) {
						System.out.println("Interrupted!");
						break;
					}
				}
				
			}
		});
		
		t1.start();
		
		Thread.sleep(5000);
		
		t1.interrupt();
		
		t1.join();
		
		System.out.println("Finished.");

	}

}
