package Basic.AADesign;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{
	private int balance = 10000;
	
	public void deposit(int amount){
		balance = balance + amount;
	}
	
	public void withdraw(int amount){
		balance = balance - amount;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public static void transfer(Account acc1, Account acc2, int amount){
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
}

class Ruunner {
	
	private Account acc1 = new Account();
	private Account acc2 = new Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException{
		
		while(true){
			
			//acquire locks
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			
			try{
				gotFirstLock = firstLock.tryLock(); //return immediately true or false .no time out.
				gotSecondLock = secondLock.tryLock();
			}
			finally{
				if (gotFirstLock && gotSecondLock){
					return;
				}
				if (gotFirstLock){
					firstLock.unlock();//give chance to other threads.
				}
				if (gotSecondLock){
					secondLock.unlock();
				}
			}
			
			//locks not acquired
			Thread.sleep(1);
			
		}
		
	}
	
	public void firstThread() throws InterruptedException{
		Random random = new Random();
		
		for(int i=0;i<10000;i++){
			//lock1.lock();
			//lock2.lock();
			acquireLocks(lock1, lock2);
			try{
				Account.transfer(acc1, acc2, random.nextInt(100));
			}
			finally{
				lock1.unlock();
				lock2.unlock();
			}
			
		}
		
	}
	
	public void secondThread() throws InterruptedException{
		Random random = new Random();
		
		for(int i=0;i<10000;i++){
			//lock2.lock();
			//lock1.lock();
			acquireLocks(lock2, lock1);
			try{
				Account.transfer(acc2, acc1, random.nextInt(100));
			}
			finally{
				lock2.unlock();
				lock1.unlock();
			}
		}
		
	}
	
	public void finished(){
		
		System.out.println("Account 1 balance:" + acc1.getBalance());
		System.out.println("Account 2 balance:" + acc2.getBalance());
		System.out.println("Total balance:" + (acc1.getBalance() + acc2.getBalance()));
	}
}
public class MTAvoidDeadLock {
	
	public static void main(String[] args) throws InterruptedException {
		
		final Ruunner runner = new Ruunner();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
				
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		runner.finished();
			
	}
}
