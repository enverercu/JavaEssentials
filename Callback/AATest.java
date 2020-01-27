package Basic.Callback;

import java.lang.reflect.Method;

interface callBackEvent{
	public void makeCallBack();
}

class TargetA implements callBackEvent{
	@Override
	public void makeCallBack(){
		System.out.println("TargetA is calling...");
	}
}

class TargetB implements callBackEvent{
	@Override
	public void makeCallBack(){
		System.out.println("TargetB is calling...");
	}
}

public class AATest {

	public static void main(String[] args) /*throws ClassNotFoundException
							, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException
							, IllegalArgumentException, InvocationTargetException*/ {

		String A = "Basic.Callback.TargetA";
		String B = "Basic.Callback.TargetB";
		try{
			
			Class AA = Class.forName(A);
			callBackEvent ref = (callBackEvent)AA.newInstance();
			
			Method MM = AA.getDeclaredMethod("makeCallBack");//Interface common method name
			
			MM.invoke(ref);
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
	}

}
