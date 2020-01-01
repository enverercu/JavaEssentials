package Basic.Aautil;

public class SearchInsideString {

	public static void main(String[] args){
		
		String str = "Java is best programming language";

		if (str.indexOf("C#") == -1){
			System.out.println("C# does not exists");
		}
		
		if (str.matches("J.*")){
			System.out.println("starts with J exists");
		}
		
		
		//Use SubString to get part of String in Java
		String subString = str.substring(0,4);
		System.out.println(subString);
	}
}
