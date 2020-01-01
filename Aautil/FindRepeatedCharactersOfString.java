package Basic.Aautil;

import java.util.*;
import java.util.Map.*;

public class FindRepeatedCharactersOfString {

	public static void main(String[] args) {
			

	}
	
	public static Map<Character,Integer> findDublicatedCharacters(String word){
		
		if (word == null || word.isEmpty()){
			return Collections.emptyMap();
		} 
		
		char[] charArray = word.replaceAll("[^a-zA-Z]", "").toCharArray();
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(char c:charArray){
			if (!map.containsKey(c)){
				map.put(c, 1);
			}else{
				int count = map.get(c) + 1;
				map.put(c,count);
			}
		}
		
		for(Map.Entry entry:map.entrySet()){
			System.out.print(entry.getKey() + "-" + entry.getValue() + " ,");
		}
		
		return map;
	}

}
