package Basic.Multithread;

class ThreadSampleExt extends Thread{	
	public void run(){
		try{
			System.out.println("Ext : " + Thread.currentThread().getId());
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
}

class ThreadSampleImp implements Runnable{
	public void run(){
		try{
			System.out.println("Imp : " + Thread.currentThread().getId());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

public class MultiThread {

	public static void main(String[] args){
		
		ThreadSampleExt threadEx = new ThreadSampleExt();
		Thread threadImp = new Thread(new ThreadSampleImp());
		
		threadEx.start();
		threadImp.start();
		
	}
}
