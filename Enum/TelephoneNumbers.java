package Basic.Enum;

import java.util.*;

//As a result of being cached, the enum values are iterated only once, and the valueOfLabel() method is simplified.
//As an alternative, we can lazily construct the cache when it is first accessed in the valueOfLabel() method. 
//In that case, map access must be synchronized to prevent concurrency problems.

public enum TelephoneNumbers{
	TR(90),
	DE(49);
	
	private static final Map<Integer,TelephoneNumbers> CACHE_VALUES = new HashMap<>();
	
	static{
		for(TelephoneNumbers e: TelephoneNumbers.values()){
			CACHE_VALUES.put(e.code, e);
		}
	}
	
	public final int code; //FOR ASSIGNING VALUES
	
	private TelephoneNumbers(int code){ //PRIVATE CONSTRUCTOR FOR ASSIGNING VALUES
		this.code = code;
	}
	
	public static TelephoneNumbers valueOfNumbers(Integer code){
		return CACHE_VALUES.get(code);
	}
	
	public static void main(String[] args){
		TelephoneNumbers t = TelephoneNumbers.valueOfNumbers(90);
		System.out.println(t.code);
	}
}

