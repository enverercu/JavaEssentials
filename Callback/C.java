package Basic.Callback;

interface OnBasicAsyncEventListener{
	
	void onBasicEvent();
}

class D implements OnBasicAsyncEventListener{
	
	@Override
	public void onBasicEvent(){
		
		System.out.println("Performing callback after Asynchronous Task"); 
        // perform some routine operation
		
	}
}

public class C {
	
	public OnBasicAsyncEventListener mListener; //listener field
	
	//setting the listener
	public void registerAsyncListener(OnBasicAsyncEventListener mListener){
		
		this.mListener = mListener;
		
	}
	
	// My Asynchronous task
	public void doStuff(){
		
		// An Async task always executes in new thread
		new Thread(new Runnable(){
			
			public void run(){
				
				// perform any operation 
                System.out.println("Performing operation in Asynchronous Task"); 
  
                // check if listener is registered. 
                if (mListener != null) { 
  
                    // invoke the callback method of class A 
                    mListener.onBasicEvent(); 
                } 
				
			}
				
		}).start();		
		
	}
	
	public static void main(String[] args){
		
		C obj = new C();
		OnBasicAsyncEventListener mListener = new D();
		obj.registerAsyncListener(mListener);
		obj.doStuff();
	}

}
