package Basic.AADesign;

import java.util.*;

interface Events{
    void updateValue();
}
class ThreadA extends Thread implements Events{
    @Override
    public void run(){
         while(true){
            updateValue();
        }
    }
    @Override
    public void updateValue(){
        synchronized(MTCreateDeadLock.lock1){
            synchronized(MTCreateDeadLock.lock2){
                System.out.println("threadA...");   
            }
        }
    }
}
class ThreadB implements Runnable, Events{
    @Override
    public void run(){
        while(true){
            updateValue();
        }
    }
    @Override
    public void updateValue(){
        synchronized(MTCreateDeadLock.lock2){
            synchronized(MTCreateDeadLock.lock1){
                System.out.println("threadB...");   
            }
        }
    }
}
public class MTCreateDeadLock
{
    
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();
    
	public static void main(String[] args) {
        
        ThreadA t1 = new ThreadA();
        Thread t2 = new Thread(new ThreadB());
        
        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
      
	}

}
