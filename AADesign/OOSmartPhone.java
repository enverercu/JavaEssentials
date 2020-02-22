package Basic.AADesign;

abstract class SmartPhone{ //basic structure and get must have properties
	private String name; //MUST HAVE PROPERTY
	
	public SmartPhone(String name){ //add constructor --> FORCES SUBCLASSES CALLING SUPER CONSTRUCTOR.
		this.name = name;
	}
	
	public String getName(){ 
		return this.name;
	}
	
}

interface Call{ //behaviours
	public void makeCall();
}

interface Message{ //behaviours
	public void sendSMS();
}

class Iphone extends SmartPhone implements Call, Message{
	
	public Iphone(String name){ //Forces both create IPhone and calling super constructor. GREAT!
		super(name);
	}
	
	@Override
	public void makeCall(){
		System.out.println(super.getName() +  " Making Call...");
	}
	
	@Override
	public void sendSMS(){
		System.out.println(super.getName() + " Sending SMS...");
	}
	
}

public class OOSmartPhone {
	
	public static void main(String[] args){
		
		Iphone ayfon = new Iphone("iPhone X"); //must assign phone name.
		System.out.println(ayfon.getName());
		ayfon.makeCall();
		ayfon.sendSMS();
	}

}
