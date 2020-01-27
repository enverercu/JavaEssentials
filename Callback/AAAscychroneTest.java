package Basic.Callback;
import java.util.*;
import java.lang.reflect.*;
import org.junit.*;
import static org.junit.Assert.*;

interface CallBackEvent{
	public void doWork();
}
class klass implements CallBackEvent{
	private Set<Integer> set = new HashSet<Integer>();
	@Override
	public void doWork(){
		for(int i = 0;i<10000000;i++){
			set.add(Integer.valueOf(i));
		}
		System.out.println("klass doWork completed.");
	}
}

public class AAAscychroneTest {
	
	@Test
	public void m1(){
		
		System.out.println("CallBack start");
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run(){
				try{
					Class A = Class.forName("Basic.Callback.klass");
					CallBackEvent ref = (CallBackEvent)A.newInstance();
					Method m = A.getDeclaredMethod("doWork");
					m.invoke(ref);
					
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		
		t1.start();
		
		System.out.println("Main program other works continue...");
		
		try {
			System.out.println("Waiting for Callback return...");
			t1.join();
			System.out.println("Callback completed.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	
	}

}
