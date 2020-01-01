package Basic.Aautil;

import java.util.*;

public class FindDublicateWordsInString {

	public static void main(String[] args){
		
		String test = "This sentence contains one or two words, one and two";
		
		Set<String> dublicates = dublicateWords(test);
		
		System.out.println("input:" + test);
		System.out.println("output:" + dublicates);
	}
	
	public static Set<String> dublicateWords(String input){
		
		if (input == null || input.isEmpty()){
			return Collections.emptySet();
		}
		
		Set<String> dublicates = new HashSet();
		
		String cleanWords  = input.replaceAll("[^a-zA-Z ]", "");
		
		String[] words = cleanWords.split("\\s+");
		
		Set<String> set = new HashSet();
		
		for(String word:words){
			if ( !set.add(word) ){
				dublicates.add(word);
			}
		}
		
		return dublicates;
		
	}
}
