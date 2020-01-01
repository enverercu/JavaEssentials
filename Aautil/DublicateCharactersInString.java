package Basic.Aautil;

import java.util.*;
import java.util.Map.*;

public class DublicateCharactersInString {

	public static void main(String[] args){
		
	}
	
	public static Map<Character,Integer> find(String input){
		
		char[] charArray = input.toCharArray();
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Map<Character,Integer> linked = new LinkedHashMap<Character,Integer>();
		
		for(char c:charArray){
			
			if (!map.containsKey(c)){
				map.put(c, 1);
			}
			else
			{
				int count = map.get(c);
				map.put(c, count + 1);
			}
	
		}
		
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			
			if (entry.getValue() > 1)
			{
				linked.put(entry.getKey(), entry.getValue());
				System.out.println(entry.getKey() + "-" + entry.getValue());
			}
		}
		
		return linked;
		
	} 
}
