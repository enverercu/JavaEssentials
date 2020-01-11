package Basic.Enum;

interface Eveents{
    public int doSomething(int x, int y);
    public States nextStep();
}
enum States implements Eveents{
    INITIAL(0){
        @Override
        public int doSomething(int x,int y){
            return x + y;
        }
        @Override
        public States nextStep(){
            return NEXT_STEP;
        }
    },
    NEXT_STEP(1){
        @Override
        public int doSomething(int x, int y){
            return x * y;
        }
        @Override
        public States nextStep(){
            return FINAL;
        }
    },
    FINAL(2){
        @Override
        public int doSomething(int x, int y){
            return x - y;
        }
        @Override
        public States nextStep(){
            return this;
        }
    };
    
    public final int value;
    
    private States(int value){
        this.value = value;
    }
}

public class Main
{
    
	public static void main(String[] args) {
        for(States s:States.values()){
            System.out.println(s.value + " - " + s.doSomething(5,2));
        }
        
        States state;
        state = States.INITIAL;
        System.out.println(state.doSomething(8,4));
        state = state.nextStep();
        System.out.println(state);
        System.out.println(state.doSomething(20,10));
        state = state.nextStep();
        System.out.println(state);
        state = state.nextStep();
        System.out.println(state);
	}
}

