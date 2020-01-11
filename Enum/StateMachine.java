package Basic.Enum;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

enum State{
	INITIAL {
		@Override
		public State doSomething(String str){
			System.out.println("INITIAL:" + str);
			return NEXT_STEP;
		}
	},
	NEXT_STEP{
		@Override
		public State doSomething(String str){
			System.out.println("NEXT_STEP:" + str);
			return FINAL;
		}
	},
	FINAL{
		@Override
		public State doSomething(String str){
			System.out.println("FINAL:" + str);
			return this;
		}
	};
	
	public abstract State doSomething(String str);
	
	public State getState(){
		return this;
	}
}

interface Events{
	public newStates doOperation();
}
enum newStates implements Events{
	INITIAL{
		@Override
		public newStates doOperation(){
			System.out.println("INITIAL");
			return FINAL;
		}
	},
	FINAL{
		@Override
		public newStates doOperation(){
			System.out.println("FINAL");
			return this;
		}
	};
}

public class StateMachine {

	private static State state;
	
	@BeforeClass
	public static void beforeClass(){
		state = State.INITIAL;
	}
	
	@Test
	public void m1(){
		assertEquals(State.INITIAL,state.getState());
	}
	
	@Test
	public void m2(){
		assertEquals(State.NEXT_STEP,state.INITIAL.doSomething("initial"));
	}
	
	@Test
	public void m3(){
		state = state.NEXT_STEP.doSomething("next");
		assertTrue(State.FINAL == state.getState());
	}
	
	@Test
	public void m4(){
		state = state.FINAL.doSomething("final");
		System.out.println(state.getState());
	}
	
}
