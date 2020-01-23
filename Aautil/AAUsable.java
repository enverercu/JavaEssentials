package Basic.Aautil;

import java.util.*;

public class AAUsable {

	public static void main(String[] args) {
		
		String str = "abcdcef";
        String str2 = "acbecdf";
        
        String clean = str.replaceAll("[^a-zA-Z]","");//USE_0
        
        char[] charArray = str.toCharArray();//USE_1
        StringBuilder builder = new StringBuilder(str2);//USE_2
        for(char c:charArray){//USE_3
        	int index = builder.indexOf(""+c);//USE_4
        	builder.deleteCharAt(index);//USE_5
        }
        if (builder.length()== 0) //USE_6
        {return;}
        
        int digits = 12345;
        int newDigits = digits / 10; //1234 //USE_7
        int remainder = digits % 10; //5 //USE_8
        
        if ( digits % 2 == 0){ //USE_9	
        }
        
        char[] c1 = str.toCharArray();
        char[] c2 = str.toCharArray();
        
        Arrays.sort(c1);//USE_10
        Arrays.sort(c2);
        
        boolean isEqual = Arrays.equals(c1, c2); //FIRST SORT // USE_11
        
        Set<Integer> set = new HashSet<Integer>(); //unique elements //USE_12
        Set<Integer> linked = new LinkedHashSet<Integer>(); // unique and insert order //USE_13
        Set<Integer> trees = new TreeSet<Integer>(); //unique and sorted //USE_14
        Map<Integer,String> map = new HashMap<Integer,String>(); //GENERAL DATA STORE  //USE_15
        Map<Character,Integer> linkedMap = new LinkedHashMap<Character,Integer>(); //insert order //USE_16
        Map<Integer,String> treeMap = new TreeMap<Integer,String>(); //sort by key //USE_17
        List<Integer> list = new ArrayList<Integer>(); //insert order //USE_18
        List<Integer> linkedList = new LinkedList<Integer>(); //insert order //USE_19
        
        trees = new TreeSet<Integer>(set); //sort a set //USE_20
        treeMap = new TreeMap<Integer,String>(map); //sort a map //USE_21

        Map<Character,Integer> hashmap = new HashMap<Character,Integer>();
        for (char c:c1){ //FILLING HASHMAP
        	if (!hashmap.containsKey(c)){ //USE_22
        		hashmap.put(c, 1); //USE_23
        	}else{
        		int count = hashmap.get(c); //USE_24
        		hashmap.put(c, count + 1);
        	}
        }
        
        for(Map.Entry<Character, Integer> entry: hashmap.entrySet()){ //USE_25
        	char c = entry.getKey(); //USE_26
        	int i = entry.getValue(); //USE_27
        }
        
        for(Integer i:set){ //USE_28
        	
        }
        
        Iterator iterr = set.iterator(); //USE_46
		while(iterr.hasNext()){ //USE_47
			System.out.println(iterr.next()); //USE_48
		}
        
        for(Integer i:list){ //USE_29
        	
        }
        
        String sentence = "I am programming with Java  8";
        String[] words = sentence.split(" "); //one space //USE_30
        String[] wordds = sentence.split("\\s+"); //multiple space //USE_31
        
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        for(String s:words){
        	if (!set1.add(s)){ //if have dublicates return false //USE_32
        		set2.add(s);
        	}
        }
        
        String sstr = "alsldksldkjjwlkj";
        char[] cArray = sstr.toCharArray();
        StringBuilder sbuilder = new StringBuilder();
        for(int i=cArray.length-1;i>=0;i--){//reverse a string //USE_33
        	sbuilder.append(cArray[i]); //USE_34
        }
        String reverse = sbuilder.toString(); //Stringbuilder to String //USE_34
        
        Integer number = 123456;
        Integer dividend = 0;
        Integer remainderr = 0;
        StringBuilder sb = new StringBuilder();
        while(number > 0){
        	dividend = number / 10;
        	remainderr = number % 10; //reverse an integer //USE_35
        	sb.append(remainderr);
        	number = dividend;
        }
        Integer result = Integer.valueOf(sb.toString()); //setting String to Integer //USE_36
        
        
        String[] sttr = new String[] {"ABC","BSS","CRR"};
		List<String> lisst = Arrays.asList(str); //string array to list //USE_37
        
      	String[] s = new String[] {"AA","BB","CC"};
      	List<String> la = new ArrayList<String>(Arrays.asList(s)); //string array to arraylist //USE_38
      	
      	List<String> lstr = new ArrayList<String>();
		String[] strArray = lstr.toArray(new String[lstr.size()]); //arraylist to string array //USE_39
		
		int[] inta = {1,2,3};
		List<Integer> listint = new ArrayList<Integer>(inta.length); //primitives to arraylist
		for(int i:inta){
			listint.add(i); //USE_40
		}
				
		char[] alphabet = new char[26];
		for(char c='a'; c<'z';c++){
			alphabet[c-'a'] = c; //form a alphabet char array //USE_41
		}
			    			   
		String sr = "ABCDEFG";
		for(int i=0;i<sr.length()-1;i++){
			char c = sr.charAt(i); //fetch char from string //USE_42
		}
		
		String sstrr = new String(alphabet); //convert char array to string //USE_43
		
		int[] intArray = { 1, 2, 3, 4, 5 };
		String intArrayString = Arrays.toString(intArray); //convert int array to String //USE_44
		
		int[] iarr = {2,3,4};
		int[] newArray = Arrays.copyOf(iarr, iarr.length + 1); //copy an array //USE_45
		newArray[newArray.length - 1] = 5;
		
		double x = 3;
		double y = 5;
		double z = -9;
		double r = 1.27d;
		
		double pow = Math.pow(3, 5);//USE_49
		double sqr = Math.sqrt(5);//USE_50	
		double abs = Math.abs(z);//USE_51		
		double roun = Math.round(r);//USE_52
		double rand = Math.random(); //0.0 and 1.0 between //USE_53
		
		Random random = new Random();
		int rrandom = random.nextInt(100); //0-99 //USE_54
		
		long start = System.currentTimeMillis(); //USE_55
		
	}

}
