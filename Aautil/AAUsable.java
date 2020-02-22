package Basic.Aautil;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.io.*;

public class AAUsable {

	public static void main(String[] args) {
		
		String str = "abcdcef";
        String str2 = "acbecdf";
        
        String clean = str.replaceAll("[^a-zA-Z]","");//USE_0
        
        char[] charArray = str.toCharArray();//USE_1
        StringBuilder builder = new StringBuilder(str2);//USE_2
        String s21 = new String(str2); //char array to string
        builder.setLength(0); //clear a stringbuilder
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
        
        boolean isEqual = Arrays.equals(c1, c2); //must be in same order, SORT FIRST // USE_11
        
        Set<Integer> set = new HashSet<Integer>(); //unique elements //USE_12
        Set<Integer> linked = new LinkedHashSet<Integer>(); // unique and insert order //USE_13
        Set<Integer> trees = new TreeSet<Integer>(); //unique and sorted //USE_14
        Map<Integer,String> map = new HashMap<Integer,String>(); //GENERAL DATA STORE  //USE_15
        Map<Character,Integer> linkedMap = new LinkedHashMap<Character,Integer>(); //insert order //USE_16
        Map<Integer,String> treeMap = new TreeMap<Integer,String>(); //sort by key //USE_17 //new TreeMap<Integer,String>(new SortByName());
        Map<Integer,String> table = new Hashtable<Integer,String>();//syncronized. //USE_98
        Map<Integer,String> syncMap = Collections.synchronizedMap(map);//synchronized. //USE_99 
        ConcurrentHashMap<Integer,String> conMap = new ConcurrentHashMap();//syncronized. //USE_100  //Unlike Hashtable and Synchronized Map, ConcurrentHashMap "never locks whole Map", instead, it "divides the map into segments and locking" is done on those.Default concurrency level is 16, and accordingly Map is divided into 16 part.This means, 16 thread can operate on Map simultaneously until they are operating on different part of Map.
        List<Integer> list = new ArrayList<Integer>(); //insert order //USE_18
        List<Integer> conList = Collections.synchronizedList(list); //synchronized. //USE_101
        List<Integer> linkedList = new LinkedList<Integer>(); //insert order //USE_19
        Queue<String> q = new LinkedList<String>();//USE_114
        ArrayDeque<Integer> adq = new ArrayDeque<>();//USE_88 //double ended. add both to head and tail.
        BlockingQueue<StringBuilder> queue = new ArrayBlockingQueue(1);//synchronized. //USE_111 //always bounded --> array --> contiguous --> memory not efficient
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();//USE_112//So in case you need an unbounded blocking queue, LinkedBlockingQueue used as a BlockingQueue
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>();//USE_113
        
        //ArrayDeque<Integer> adq = new ArrayDeque<>();
        //STACK - Last in first out - push() - pop() 
      	adq.push(10);//USE_89
      	adq.push(11);
      	adq.push(99);
      	while(!adq.isEmpty()){
			System.out.println(adq.pop());//99 11 10 //USE_90
		}
      	//QUEUE - First in first out - add() - remove()
      	adq.add(1);//USE_91
      	adq.add(2);
      	adq.add(3);
      	while(!adq.isEmpty()){
			System.out.println(adq.remove()); //1 2 3 //USE_92
		}
      	
      	//FIFO
      	//Queue<String> q = new LinkedList<String>();//USE_93
      	//This method adds the specified element at the end of Queue
        q.add("john");//USE_94
        q.add("mary");
        //this returns the head of the Queue
        System.out.println("Head : " + q.peek());//john FIFO
        //this would remove the first element from the Queue
        System.out.println("Removed element : " + q.remove());//john //USE_95
        
        //Queue<String> q = new LinkedList<String>();//USE_93
        pr.add(3);
        pr.add(1);
        pr.add(2);
        while( pr.size() > 0 ){//pr.poll returns null, pr.peak() returns null //USE_96
        	System.out.println(pr.poll());//poll() SORTED !  pr.peak or pr.remove NOT SORTED //USE_97
        }
      	
        table.put(1, "andy");
        String value = table.get(1);
        
        trees = new TreeSet<Integer>(set); //sort a set //USE_20
        trees.add(1);
        treeMap = new TreeMap<Integer,String>(map); //sort a map by key //USE_21
        treeMap.put(1, "andy");
        
        map.putIfAbsent(1, "andy");//Bu sekilde eklersek HashMap distinct olur.//USE_85
        String strring = map.getOrDefault(0,"name"); //birsey bulamazsa null donmez , name doner. //USE_86

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
        
        Iterator iter = hashmap.entrySet().iterator();
	    while(iter.hasNext()){
	        Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>)iter.next();//USE_116
	        System.out.println(entry.getKey() + "-" + entry.getValue());
	    }
        
        for(Integer i:set){ //USE_28
        	
        }
        
        Iterator iterr = set.iterator(); //USE_46
		while(iterr.hasNext()){ //USE_47
			System.out.println(iterr.next()); //USE_48
		}
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add("B");
		aList.add("C");
		aList.add("D");
		aList.add("C");
		String firstItem = aList.get(0);
		//Swapping 2nd(index 1) element with the 5th(index 4) element
	    Collections.swap(aList, 1, 4); //USE_102
	    int min = Collections.min(list); //USE_109
		int max = Collections.max(list); //USE_110	
		System.out.println("min:" + min + " max:" + max);
		for(String s:aList){
			System.out.print(s + " ");
		}	
		Iterator<String> iter = aList.iterator();	
		while(iter.hasNext()){
			String s = iter.next();
			if (s.equals(String.valueOf("C"))){
				iter.remove();//USE_86
			}
		}	
		System.out.println();
		Iterator<String> newIter = aList.iterator();
		while (newIter.hasNext()){
			System.out.print(newIter.next() + " ");
		}
		
		
		Set<Integer> sett = new HashSet<Integer>();
        sett.add(1);
        Iterator<Integer> itera = sett.iterator(); //<Integer> olmazsa warning verir.
        while(itera.hasNext()){
            System.out.println(itera.next());
        }
        
        for(Integer i:list){ //USE_29
        	
        }
        
        String sentence = "I am programming with Java  8";
        String[] words = sentence.split(" "); //one space ! Java  8: Java, ,8 //USE_30
        String[] wordds = sentence.split("\\s+"); //multiple space //USE_31
        
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new LinkedHashSet<String>(); //insert order
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
        	//sbuilder.length() //USE_57
        	//sbuilder.deleteCharAt(index) //USE_58
        	//sbuilder.substring(0,1) //start,end //USE_59
        	//sbuilder.reverse() //USE_60
        }
        String reverse = sbuilder.toString(); //Stringbuilder to String //USE_34
        
        String Str="Java";
        boolean bool = Str.equalsIgnoreCase("JAVA");//USE_61
        boolean boolstr = Str.startsWith("Ka");//USE_62
		boolean bstr = Str.contains("a");//USE_63
		int indexx = Str.indexOf("v");//USE_64
		String substr = Str.substring(0,4);//start,end USE_65
		
		String hello = "hello";
        hello.concat(" world");
        System.out.println(hello); //hello
        hello = hello.concat(" world"); //USE_68
        System.out.println(hello);//hello world
        
      //ARRAY DEQUE FOR SUBARRAY
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int subArrayLen = 3;
        int[] arr = {4,5,7,8,9,1,3,4,6};
        for(int i=0;i<arr.length;i++){
            deque.add(arr[i]); //add to tail.USE_69
            if (deque.size() == subArrayLen){ //USE_70
                for(int j:deque) System.out.print(j);
                System.out.println();
                int first = deque.remove();//remove from head.USE_71
            }
        }
        
        //MANIPULATING ARRAYLIST
        List<Integer> llist = new ArrayList<Integer>();
      	llist.add(1);
      	llist.get(0);//index
      	llist.set(0, 2);
      	System.out.println(llist.isEmpty());//USE_72
      	System.out.println(llist.contains(3));//USE_73
      	System.out.println(llist.indexOf(5));//USE_74
      	System.out.println(llist.size());//USE_75
      	Collections.swap(llist, 1, 4);//Swapping 2nd(index 1) element with the 5th(index 4) element //USE_76
      	llist.remove(0);//index //USE_77
      	llist.clear(); //USE_78
      	
      	//MANIPULATING HASHMAP
      	Map<String,String> maap = new HashMap<String,String>();
      	maap.put("1", "one");//USE_79
      	maap.get("1");//key //USE_80
      	System.out.println(maap.containsKey("1")); //USE_81
      	maap.remove("1");//key //USE_82
      	int sizze = maap.size(); //USE_83
		
		String[] stringArray = { "a", "b", "c", "d", "e" };
		boolean b = Arrays.asList(stringArray).contains("a"); //USE_66
		System.out.println(b);
		
		char[] chhr = {'a','d'};
        String sttr = new String(chhr);//USE_67
        System.out.println(sttr);
        
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
      //setting String to Integer. Integer.valueOf(String) IMPORTANT
        Integer result = Integer.valueOf(sb.toString());  //USE_36
        
        
        String[] sitring = {"ABC","BSS","CRR"};
		List<String> lisst = Arrays.asList(sitring); //string array to list //USE_37
        
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
		for(char c='a'; c<='z';c++){
			alphabet[c-'a'] = c; //form a alphabet char array //USE_41
		}
		
		char[] alphabett = new char[26];
        char[] nonVowels = new char[21];
        List<Character> listt = new ArrayList<Character>();
        listt.add('a');listt.add('e');listt.add('i');listt.add('o');listt.add('u');
        StringBuilder sbuild = new StringBuilder();
        int counter = 0;
        for(char c='a';c<='z';c++){
            alphabet[c-'a'] = c;
            if (!list.contains(c)){ //USE_84
                nonVowels[counter] = c;
                sbuild.append(String.valueOf(c));
                counter++;
            }
        }
        for(char c:nonVowels){
            System.out.print(c);
        }
        
        System.out.println();
        System.out.println(sbuild.toString());
			    			   
		String sr = "ABCDEFG";
		for(int i=0;i<sr.length()-1;i++){
			char c = sr.charAt(i); //fetch char from string //USE_42
		}
		
		String sstrr = new String(alphabet); //convert char array to string //USE_43
		
		int[] intArray = { 1, 2, 3, 4, 5 };
		String intArrayString = Arrays.toString(intArray); //convert int array to String //USE_44
		
		int[] iarr = {2,3,4};
		int[] newArray = Arrays.copyOf(iarr, iarr.length + 1); //copy an array //USE_45
		int[] newArrayy = Arrays.copyOfRange(iarr,0, iarr.length + 1); //copy the content and resize
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
		
		double[] source = {7,11};
        double[] target = new double[2];
        int ccount = 0;
        for(double i:source){
            target[ccount] = Math.pow(i,2);//works with double
            ccount++;
        }
        for(double dd:target){
            System.out.println(dd);
        }
		
		Random random = new Random();
		int rrandom = random.nextInt(100); //0-99 //USE_54
		
		long start = System.currentTimeMillis(); //USE_55
		
        String sit = "A new hope is   already taken  place!   ";
        String klean = sit.trim().replaceAll(" +"," ");  //String.trim() : Returns a copy of the string, with leading and trailing whitespace omitted
        System.out.println(klean);
		
        String strs = "Let's a new hope is already taken  place!";
        String cleean = strs.replaceAll(" +"," "); //multiple space to one space
        String cleans = cleean.replaceAll("[^a-zA-Z' ]","");
        String[] strsArr = cleans.split(" ");
        StringBuilder sbs = new StringBuilder();
        for(String ss:strsArr){
            char[] chr = ss.toCharArray();
            sbs.append(Character.toUpperCase(chr[0])); //USE_56
            for(int i=1; i<chr.length; i++){
                sbs.append(chr[i]);
            }
            sbs.append(" ");
        }
        
        
        
        System.out.println(sbs.toString());
        
        String stiring = "john ann mary ann";
        String[] sp = stiring.split(" ");
        List<String> liist = Arrays.asList(sp);
        //USE_87 :import java.util.stream.*
        liist = liist.stream().distinct().map(name -> name.substring(0,1).toUpperCase() + name.substring(1)).sorted(String::compareTo).collect(Collectors.toList());
        liist.stream().forEach(System.out::println);
        
        //CLASS and Collections can serial.
        ArrayList<String> al=new ArrayList<String>();
        al.add("Hello");
        al.add("Hi");
        al.add("Howdy");
        try{
          FileOutputStream fos= new FileOutputStream("D:/myfile.txt");//USE_103
          ObjectOutputStream oos= new ObjectOutputStream(fos);//USE_104
          oos.writeObject(al);//USE_105
          oos.close();
          fos.close();
        }catch(IOException ioe){
             ioe.printStackTrace();
         }
        
        ArrayList<String> arraylist= new ArrayList<String>();
        try
        {
            FileInputStream fis = new FileInputStream("D:/myfile.txt");//USE_106
            ObjectInputStream ois = new ObjectInputStream(fis);//USE_107
            arraylist = (ArrayList) ois.readObject(); //(Class) CASTING with objects //USE_108
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
        for(String tmp: arraylist){
            System.out.println(tmp);
        }
        
        String output = String.format("%s = %d","Joe",35);//Joe = 35  //USE_115
        String s1 = "Java";
        String s2 = "Programming Language";
        String s3 = "Best";
        String o1 = String.format("%3$s %2$s is %1$s",s1,s2,s3); //"Best Programming Language is Java"
        
        String s6 = String.format("%1$5s", "99").replace(" ", "0");//"00099"
        String s7 = String.format("%1$-5s", "99").replace(" ", "0");//"99000"
		
		
		
	}

}
