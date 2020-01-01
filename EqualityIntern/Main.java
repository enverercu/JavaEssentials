package Basic.EqualityIntern;

public class Main {

	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "hello";
		String str3 = "hello".intern();
		if ( str1 == str2 )
		{
		   System.out.println("str1 and str2 are same");
		}
		if ( str1 == str3 )
		{
		   System.out.println("str1 and str3 are same" );
		}
		
//		We are assuming that str1 and str3 are same will be printed as str3 is interned, 
//		and str1 and str2 are same will not be printed. Actual output is: 
//		both lines are printed, which make clear that by default String constants are interned.

	}

}
