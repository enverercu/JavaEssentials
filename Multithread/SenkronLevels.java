package Basic.Multithread;
//A Class used to send a message
class Sender 
{ 
    public void send(String msg) 
    { 
        System.out.println("Sending\t"  + msg ); 
        try
        { 
            Thread.sleep(1000); 
        } 
        catch (Exception e) 
        { 
            System.out.println("Thread  interrupted."); 
        } 
        System.out.println("\n" + msg + "Sent"); 
    } 
} 


//An alternate implementation to demonstrate 
//that we can use synchronized with method also. 
class SenderX  
{ 
 public synchronized void send(String msg) 
 { 
     System.out.println("Sending\t" + msg ); 
     try 
     { 
         Thread.sleep(1000); 
     }  
     catch (Exception e)  
     { 
         System.out.println("Thread interrupted."); 
     } 
     System.out.println("\n" + msg + "Sent"); 
 } 
}
//One more alternate implementation to demonstrate 
//that synchronized can be used with only a part of  
//method
class SenderXX  
{ 
    public void send(String msg) 
    { 
        synchronized(this)  //SenderXX dersen class ý locklar "this" dersen sadece objeyi locklar
        { 
            System.out.println("Sending\t" + msg ); 
            try 
            { 
                Thread.sleep(1000); 
            }  
            catch (Exception e)  
            { 
                System.out.println("Thread interrupted."); 
            } 
            System.out.println("\n" + msg + "Sent"); 
        } 
    } 
} 

//Class for send a message using Threads 
class ThreadedSend extends Thread 
{ 
private String msg; 
Sender  sender; 

// Recieves a message object and a string 
// message to be sent 
ThreadedSend(String m,  Sender obj) 
{ 
   msg = m; 
   sender = obj; 
} 

public void run() 
{ 
   // Only one thread can send a message 
   // at a time. 
   synchronized(sender) //senderx ve senderxx te buraya ne gelecek?
   { 
       // synchronizing the snd object 
       sender.send(msg); 
   } 
} 
}

public class SenkronLevels {
	public static void main(String args[]) 
    { 
        Sender snd = new Sender(); 
        ThreadedSend S1 = 
            new ThreadedSend( " Hi " , snd ); 
        ThreadedSend S2 = 
            new ThreadedSend( " Bye " , snd ); 
  
        // Start two threads of ThreadedSend type 
        S1.start(); 
        S2.start(); 
  
        // wait for threads to end 
        try
        { 
            S1.join(); 
            S2.join(); 
        } 
        catch(Exception e) 
        { 
            System.out.println("Interrupted"); 
        } 
    } 
}
