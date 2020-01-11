package Basic.Multithread;

class Chat{
	
	boolean flag = false;
	
	public synchronized void Question(String msg){	
		if (flag){
			try{
				wait();
			}
			catch(InterruptedException e ){
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
		
	}
	
	public synchronized void Answer(String msg){
		if (!flag){
			try{
				wait();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = false;
		notify();
		
	}
}

public class MultiComm {

	public static void main(String[] args){
		
		Chat m = new Chat();
		
		new Thread(new Runnable(){
			
			String[] questions = {"Hi","How are you?"};
			
			public void run(){
				
				for (String str:questions){
					m.Question(str);
				}
				
			}	
		}).start();
		
		new Thread(new Runnable(){
			
			String[] answers = {"Hi","I am fine and you?"};
			
			public void run(){
				for(String str:answers){
					m.Answer(str);
				}
			}
			
		}).start();
	}
}
