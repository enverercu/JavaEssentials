package Basic.RegularExpression;

import java.util.regex.*;

public class AATest {
	
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("very");
		Matcher m = p.matcher("i am very happy and very charming!");
		
		while(m.find()){
			System.out.println("very:" + m.start() + "-" + m.end());
		}
		
		p = Pattern.compile("(.*)very(.*)");
		m = p.matcher("i am very happy and very charming!");
		System.out.println("very exists :" + m.matches());
		
		while(m.find()){
			System.out.println("very:" + m.start() + "-" + m.end());
		}
		
		System.out.println("Exist: " + m.lookingAt());
		
		System.out.println(m.replaceAll(""));
		
		p = Pattern.compile("\\d");
		
		String[] result = p.split("enver1ercu2yilmaz");
		
		for(String s:result){
			System.out.println(s);
		}
		
		p = Pattern.compile("[\\s]");
		m = p.matcher("enver  ercu yilmaz");
		System.out.println(m.replaceAll(""));
		
		String[] text = p.split("enver ercu yilmaz");
		for(String s:text){
			System.out.println(s);
		}
		
		p = Pattern.compile("[\\d]");
		m = p.matcher("enver 1 ercu 2 yilmaz");
		System.out.println(m.replaceAll(""));
		
		p = Pattern.compile("[a-zA-Z]");
		m = p.matcher("enverercuyilmaz");
		System.out.println(m.matches());
		
		char c = 'c';
		p = Pattern.compile(String.valueOf(c));
		m = p.matcher("abcckdlslsc");
		int count = 0;
		while(m.find()){
			count++;
		}
		System.out.println("count:" + count);
		
		p = Pattern.compile("[0-9]+");
		m = p.matcher("asldkjfls0skjdhfksdj123lsdkjflkj778");
		while(m.find()){
			System.out.print(" " + m.group());
		}
		
		System.out.println();
		
		p = Pattern.compile("[^0-9]+");
		m = p.matcher("asldkjfls0skjdhfksdj123lsdkjflkj778");
		while(m.find()){
			System.out.print(" " + m.group());
		}
		
		System.out.println();
		
		p = Pattern.compile("[a-zA-Z]+");
		m = p.matcher("asldkjfls0  skjd ?=%hfksdj123lsdkjflkj778");
		while(m.find()){
			System.out.print(" " + m.group());
		}
		
		System.out.println();
		
		p = Pattern.compile("[^a-zA-Z0-9\\s]");
		m = p.matcher("asldkjfls0  skjd ?=%hfksdj123lsdkjflkj778");
		System.out.println(m.replaceAll(""));
		
		String str = "word1, word2 word3@word4?word5.word6"; 
        String[] arrOfStr = str.split("[, ?.@]+"); 
  
        for (String a : arrOfStr) 
            System.out.println(a);
        
        
        p = Pattern.compile("\\b[a-zA-Z]"); // \b	A word boundary
		m = p.matcher("A Computer Science Portal for Geeks");
		 while (m.find()) 
	            System.out.print(m.group()); 
		 
		System.out.println();
    
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true  
		
		System.out.println(Pattern.matches("[789]{1}[0-9]{9}", "9953038949"));//true  
		
		System.out.println(Pattern.matches("[789]{1}\\d{9}", "8853038949"));//true
		 
	}

}
