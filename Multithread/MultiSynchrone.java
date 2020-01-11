package Basic.Multithread;

class PrintDemo{
	
	public void printCount(){
		for (int i = 0; i < 9; i++){
			System.out.println(i);
		}
	}
}

class Synchrone extends Thread {

	PrintDemo PD;
	
	public Synchrone(PrintDemo pd){
		this.PD = pd;
	}
	
	public void run(){
		synchronized(PD){ // LOCK THE CLASS!!
			PD.printCount();
		}
	}
}

public class MultiSynchrone{
	
	public static void main(String[] args){
		
		PrintDemo PD = new PrintDemo();
		
		Synchrone senkron = new Synchrone(PD);
		Synchrone senkron2 = new Synchrone(PD);
		
		senkron.start();
		senkron2.start();
		
	}
	
}







