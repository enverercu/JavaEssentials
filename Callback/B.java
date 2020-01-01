package Basic.Callback;

interface OnBasicEventListener{
	
	void onBasicEvent();
}

class A implements OnBasicEventListener{
	
	@Override
	public void onBasicEvent(){
		
		System.out.println("Performing callback after synchronous Task"); 
        // perform some routine operation
		
	}
}

public class B {

	private OnBasicEventListener mListener; // listener field 
	
	// setting the listener 
	public void registerOnBasicEventListener(OnBasicEventListener mListener){
		this.mListener = mListener;
	}
	
	// my synchronous task
	public void doStuff(){
		
		// perform any operation 
        System.out.println("Performing callback before synchronous Task"); 
        
        // check if listener is registered.
        if (this.mListener != null){
        	
        	// invoke the callback method of class A
        	mListener.onBasicEvent();
        	
        }
	}
	
	public static void main(String[] args){
		
		B obj = new B();
		OnBasicEventListener mListener = new A();
		obj.registerOnBasicEventListener(mListener);
		obj.doStuff();
		
	}
	
}
