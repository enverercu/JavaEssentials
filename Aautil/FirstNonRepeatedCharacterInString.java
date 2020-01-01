package Basic.Aautil;

import java.util.*;

public class FirstNonRepeatedCharacterInString {

	public static void main(String[] args){
		
	}
	
	public static char findFirstNonDublicate(String string){
		
		char[] charArray = string.toCharArray();
		
		Map<Character,Integer> linked = new LinkedHashMap<Character,Integer>();
		
		for(char c:charArray){
			if (!linked.containsKey(c)){
				linked.put(c, 1);
			}
			else
			{
				int count = linked.get(c);
				linked.put(c, count + 1);
			}
		}
		
		for (Map.Entry<Character,Integer> entry:linked.entrySet()){
			if (entry.getValue() == 1)
			{
				return entry.getKey();
			}
		}
		
		throw new RuntimeException("didn't find any non repeated Character");
	}
}
