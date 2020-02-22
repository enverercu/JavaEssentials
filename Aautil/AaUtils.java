package Basic.Aautil;

import java.util.*;
import java.util.stream.*;

import Data.Queues.ArrayQueue;

public class AaUtils {

	public static void main(String[] args) {
		
		//CONVERT STRING ARRAY TO LIST
		String[] str = new String[] {"A","B","C"};
		List<String> list = Arrays.asList(str);

		//CONVER INTEGER ARRAY TO ARRAYLIST
		Integer[] IntArr = new Integer[] {1,2,3,4};
		List<Integer> listInt = Arrays.asList(IntArr);
		
		//CONVERT STRING ARRAY TO ARRAYLIST
		String[] s = new String[] {"AA","BB","CC"};
		List<String> la = new ArrayList<String>(Arrays.asList(s));
		
		//CONVERT ARRAYLIST TO ARRAY
		List<String> lstr = new ArrayList<String>();
		lstr.add("Some");
		String[] strArray = lstr.toArray(new String[lstr.size()]);
		
		//CONVERT PRIMITIVE int ARRAY TO ARRAYLIST
		int[] inta = new int[] {1,2,3};
		int[] intb = new int[3]; intb[0]=1;
		List<Integer> listint = new ArrayList<Integer>(inta.length);
		for(int i:inta){
			listint.add(i);
		}
		
		//CONVERT STRING TO CHAR ARRAY
		String st = "ABCDEF";
		char[] chr = st.toCharArray();
		
		//FORMING ALPHABET CHAR ARRAY
		char[] alphabet = new char[26];
	    for(char c='a'; c<'z';c++){
	      alphabet[c-'a'] = c;
	    }
	    
	    //FETCHING CHAR FROM STRING
	  	String sr = "ABCDEFG";
	  	for(int i=0;i<sr.length()-1;i++){
	  		char c = sr.charAt(i);
	  	}
	    
	    //UPPERCASE A CHAR
	    char chrc = Character.toUpperCase('a');
	    
	    //LOWERCASE A STRING
	    String newStr = String.valueOf("abcd").toLowerCase();
	    
	    //CONVERT CHAR ARRAY TO STRING
	    String sstrr = new String(alphabet);
	    
		
		//CONVERT STRINGBUILDER TO STRING
		String sstr = "a new hope";
		StringBuilder sb = new StringBuilder();
		sstr = sb.toString();
		
		//CONVERT STRINGBUILDER TO CHAR ARRAY 
        char[] array = new char[7]; 
        sb.getChars(0, 7, array, 0);// get char from index 0 to 7  and store in array start index 0
        System.out.println(array);
        
        //STRING BUILDER FUNCTIONS
		sb.append(sstr);
		sb.insert(0, "2020");
		sb.replace(0, 1, "xxx");
		sb.delete(0,1);
		sb.deleteCharAt(0);
		sb.reverse();
		String sttring = sb.substring(0,1);//index
		int size = sb.length();
		char ccchr = sb.charAt(0);
		System.out.println(sb);
		
		//STRING FUNCTIONS
		String Str="Java";  
		int len = Str.length();
		char ca = Str.charAt(2);
		boolean bool = Str.equalsIgnoreCase("JAVA");
		String newStrr = Str.toLowerCase();
		newStrr = Str.toUpperCase();
		String strn = "   Java  ";
		String sstrn = strn.trim();
		String ssstrn = strn.replace('v', 'V');
		String[] strArrray = strn.split("a");  //Java --> J,v --> length:2
		String[] newStrrr = strn.replaceAll("[^a-zA-Z ]","").split(" ");//clear all others except a-z A-z and space
		String[] newSttrr = strn.replaceAll("[^a-zA-Z0-9 ]","").split(" ");//clear all others except a-z A-z 0-9 and space
		boolean boolstr = strn.startsWith("Ka");
		boolean bstr = strn.contains("a");
		int indexx = strn.indexOf("v");
		String substr = strn.substring(0,4);//index
		
		//ARRAY FUNCTIONS
		int[] intArray = { 1, 2, 3, 4, 5 };
		String intArrayString = Arrays.toString(intArray);
		//NOW PRINT
		
		String[] stringArray = { "a", "b", "c", "d", "e" };
		boolean b = Arrays.asList(stringArray).contains("a");
		System.out.println(b);
		
		//SORT ARRAY
		int[] iarr = new int[] {2,3,4};
		Arrays.sort(iarr);
				
		//COPY AN ARRAY
		int[] newArray = Arrays.copyOf(iarr, iarr.length + 1);
		newArray[newArray.length - 1] = 5;
		
		//COMPARE TWO ARRAYS
		boolean bolean = Arrays.equals(iarr, newArray);
		
		//REMOVE DUBLICATES FROM AN ARRAY
		int[] arrdub = new int[] {1,1,2,3,3,3,4,5,5};
		int end = arrdub.length;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<end; i++){
			set.add(i);
		}
		//now if you will iterate through this set, it will contain only unique values
		Iterator iterr = set.iterator();
		while(iterr.hasNext()){
			System.out.println(iterr.next());
		}
		
		//CONCATANATE TWO ARRAYS
		int[] arr1 = new int[] {1,2};
		int[] arr2 = new int[] {3,4};
		int[] result = new int[arr1.length+arr2.length];
		System.arraycopy(arr1,0,result,0,arr1.length);
		System.arraycopy(arr2,0,result,arr1.length+1,arr2.length);
		
		//ARRAY DEQUE FOR SUBARRAY
		Deque<Integer> deque = new ArrayDeque<>();
		int arrayLen = 6;
		int subArrayLen = 3;
		for(int i=0;i<arrayLen;i++){
			deque.add(i);
			if (deque.size()==subArrayLen){
				//HERE WE HAVE 3 LEN ARRAY
				//TO DO...
				int first = deque.remove();
			}
		}
		
		//STREAM FUNCTIONS
		//Streams can be created from different element sources -> collection or array
		Stream newstream = Stream.of("a","b","c");
		
		//CONVERT STRING ARRAY TO STREAM
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);
		
		//CONVERT STREAM TO ARRAY
		String[] arrNew = stream.toArray(String[]::new);
		
		//A stream() default method is added to the Collection interface and allows creating a Stream<T> using any collection
		//CONVERT ARRAYLIST TO STREAM
		List<String> lll = new ArrayList<String>();
		Stream<String> sstream = lll.stream();
		
		//CONVERT STREAM TO ARRAYLIST
		List<String> lconverted = lll.stream().collect(Collectors.toCollection(ArrayList::new));
		
		//CONVERT STREAM TO LIST
		List<String> resultList = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
		
		//There are many useful operations that can be performed on a stream.
		//They are divided into intermediate operations (return Stream<T>) and terminal operations (return a result of definite type). 
		//Intermediate operations allow chaining.
		long count = lll.stream().distinct().count();
		//the distinct() method represents an intermediate operation, which creates a new stream of unique elements of the previous stream. 
		//And the count() method is a terminal operation, which returns stream's size.
		
		//Iterating
		for (String string : lll) {
		    if (string.contains("a")) {
		        //return true;
		    }
		}
		boolean isExists = lll.stream().anyMatch(element -> element.contains("a"));
		
		//Filtering
		Stream<String> ststring = lll.stream().filter(element -> element.contains("a"));
		
		int[] intArrayy = new int[]{2,3,4};
		int[] evenArray = Arrays.stream(intArrayy).filter(value -> value % 2 == 0).toArray();
		
		//SORT COLLECTION
		int[] arri = new int[]{5,6};
		List<Integer> lista = new ArrayList<Integer>(arri.length);
		for(int i:arri){
			lista.add(i);
		}
		Collections.sort(lista);
		
		//REVERSE ARRAY
		Collections.reverse(lista);
		
		//MIN ARRAY AND MAX ARRAY
		int min = Collections.min(lista);
		int max = Collections.max(lista);
		
		//MANIPULATING ARRAYLIST
		List<Integer> llist = new ArrayList<Integer>();
		llist.add(1);
		llist.get(0);//index
		llist.set(0, 2);
		System.out.println(llist.isEmpty());
		System.out.println(llist.contains(3));
		System.out.println(llist.indexOf(5));
		System.out.println(llist.size());
	    Collections.swap(llist, 1, 4);//Swapping 2nd(index 1) element with the 5th(index 4) element
		llist.remove(0);//index
		llist.clear();
		
		//MANIPULATING HASHMAP
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "one");
		map.get("1");//key
		System.out.println(map.containsKey("1"));
		map.remove("1");//key
		int sizze = map.size();
		for(Map.Entry x:map.entrySet()){
			String key = (String) x.getKey();
			String value = (String) x.getValue();
		}
		
		//HANDLING ITERATOR
		Iterator iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(map.get(iterator.next()));
			iterator.remove();//works
			map.remove(map.get(iterator.next()));//error
		}
		
		
		//CONVERT LINKEDLIST TO ARRAYLIST
		List<Integer> linked = new LinkedList<Integer>();
		linked.add(7);
		List<Integer> aListt = new ArrayList<Integer>(linked);
		
		//SYNCHRON ARRAYLIST
		List<String> listArr = Collections.synchronizedList(new ArrayList<String>()); 
		
		//MATH FUNCTIONS
		double x = 3;
		double y = 5;
		double z = -9;
		double r = 1.27d;
		
		double pow = Math.pow(3, 5);
		double sqr = Math.sqrt(5);
		
		double abs = Math.abs(z);
		
		double roun = Math.round(r);
		
		double rand = Math.random(); //0.0 and 1.0 between
		
		
		int j = Integer.parseInt("000000081");
		System.out.println("j: " + j);
		j = Integer.valueOf("000000081");
		System.out.println("j: " + j);
	}

}
