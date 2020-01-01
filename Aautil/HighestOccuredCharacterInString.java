package Basic.Aautil;

import java.util.*;
import java.util.Map.*;

public class HighestOccuredCharacterInString {

	public static void main(String[] args) {

	}
	
	public static Map<Character,Integer> find(String input){
		
		if (input == null || input.isEmpty()){
			return Collections.emptyMap();
		}
		
		char[] charArray = input.replaceAll("[^a-zA-Z]", "").toCharArray();
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		Map<Character,Integer> maxMap = new HashMap<Character,Integer>();
		
		for (char c:charArray){
			if (!map.containsKey(c)){
				map.put(c, 1);
			}else{
				int count = map.get(c);
				map.put(c, count+1);
			}
		}
		int max = 0;
		char c = '.';
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			if (entry.getValue() > max){
				max = entry.getValue();
				c = entry.getKey();
			}
		}
		
		maxMap.put(c, max);
		
		System.out.println(c + "-" + maxMap.get(c));
			
		return maxMap;
	}

}
