package Basic.AADesign;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

//The client will interact with the Package class
class Package{
	  private PackageState state;
	
	   //it contains a reference for managing the state, notice previousState(), nextState() and printStatus() methods where we delegate the job to the state object. 
	   //The states will be linked to each other and every state will set another one based on this reference passed to both methods.
	  
	  public Package(PackageState state){
		  this.state = state;
	  }
	  
	  public void previousState(){
	      state.prev(this);
	  }
	  public void nextState(){
	      state.next(this);
	  }
	  public void printStatus(){
	      state.printStatus();
	  }
	  
	  public void setState(PackageState state){
	      this.state = state;
	  }
	  public PackageState getState(){
		  return this.state;
	  }
}

interface PackageState{
	  void next(Package pkg);
	  void prev(Package pkg);
	  void printStatus();
}

class OrderedState implements PackageState{
	  @Override
	  public void next(Package pkg){
	      pkg.setState(new DeliveredState());
	  }
	  @Override
	  public void prev(Package pkg){
	      System.out.println("The package is in its root state");
	  }
	  @Override
	  public void printStatus(){
	      System.out.println("Ordered!");
	  }
}
class DeliveredState implements PackageState{
	  @Override
	  public void next(Package pkg){
	      pkg.setState(new ReceivedState());
	  }
	  @Override
	  public void prev(Package pkg){
	      pkg.setState(new OrderedState());
	  }
	  @Override
	  public void printStatus(){
	      System.out.println("Delivered!");
	  }
 
}
class ReceivedState implements PackageState{
	  @Override
	  public void next(Package pkg){
	      System.out.println("This package is already received by a client");
	  }
	  @Override
	  public void prev(Package pkg){
	      pkg.setState(new DeliveredState());
	  }
	  @Override
	  public void printStatus(){
	      System.out.println("Received!");
	  }
}

public class DPState
{
	static Package pkg;
	
	@BeforeClass
	public static void initialize(){
		pkg = new Package(new OrderedState());
	}
	
	@Test
	public void checkInitialState(){
		pkg.printStatus();
		pkg.nextState();
		pkg.printStatus();
	}
	
	@Test
	public void checkState(){
		pkg.printStatus();
	}

}

