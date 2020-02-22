package Basic.AADesign;

//Consider a real-life example of a man driving a car. 
//The man only knows that pressing the accelerators will increase the speed of car or applying brakes will stop the car
//but he does not know about how on pressing the accelerator the speed is actually increasing, 
//he does not know about the inner mechanism of the car or the implementation of accelerator, brakes etc in the car. 
//This is what abstraction is.
//"IMPLEMENTATION HIDING"
interface Speed{ //additional functionality
	void increaseSpeed(int amount);
	void decreaseSpeed(int amount);
}
interface Security{
	void doABSBreak();
}
//abstract class has constructor, you can set default values.
abstract class Carr implements Speed, Security{//no need to implement interfaces methods.
	String color;//common properties
	int speed;
	boolean isWorking = false;
	public Carr(String color){
		this.color = color;
		this.speed = 0;
	}
	protected void start(){ //Basic Functionality
		this.isWorking = true;
	}
	protected void stop(){ //Basic Functionality
		this.isWorking = false;
		this.speed = 0;
	}
}
class Mercedes extends Carr{ //first concrete implements methods.
	
	public Mercedes(String color){
		super(color);
	}
	@Override
	public void increaseSpeed(int amount){ //IMPLEMENTATION HIDING
		if (super.isWorking){
			super.speed = super.speed + amount;
		}  
	}
	@Override
	public void decreaseSpeed(int amount){ //IMPLEMENTATION HIDING
		if (super.isWorking) super.speed = super.speed - amount; 
	}
	@Override
	public void doABSBreak(){
		super.speed = 0;
	}
	@Override
	public String toString(){
		return "Mercedes color is " + super.color + " speed is " + super.speed;
	}
}

public class OOSpeed{
	public static void main(String[] args){
		
		Carr mercedes = new Mercedes("Red");
		mercedes.increaseSpeed(20);
		System.out.println(mercedes);
		mercedes.start(); //call from super class
		mercedes.increaseSpeed(10);
		System.out.println(mercedes);
		mercedes.stop();
		System.out.println(mercedes);
		
	}
	
}
