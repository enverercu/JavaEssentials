package Basic.Aautil;

import java.util.*;
import java.util.Map.*;
import java.util.Set.*;

import org.junit.*;
import static org.junit.Assert.*;

class komparator implements Comparator<Entry<String,Integer>>{
	
	@Override
	public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2){
		return e1.getValue().compareTo(e2.getValue());
	}
}

public class SortHashMap {

	public static Map<String,Integer> map;
	
	@BeforeClass
	public static void beforeClass(){
		map = new HashMap<String,Integer>();
	}
	
	@Before
	public void before(){
		map.clear();
		map.put("DE",5);
		map.put("EN",7);
		map.put("TR",1);
		
	}
	
	@Test
	public void m1(){ //sort by keys
		Map<String,Integer> sorted = new TreeMap<String,Integer>(map);
		
		for(Map.Entry x:sorted.entrySet()){
			System.out.println(x.getKey());
		}
	}
	
	@Test
	public void m2(){//sort by values
		
		Set<Entry<String, Integer>> entries = map.entrySet(); //get entryset
		List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(entries); // change to list
		
		Collections.sort(listOfEntries,new komparator()); //sort list by value
		
		LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size());
		   
		for(Entry<String,Integer> entry:listOfEntries){
			sortedByValue.put(entry.getKey(), entry.getValue()); //put into linkedhashmap in order
		}
		
		for(Map.Entry entry:sortedByValue.entrySet()){
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}
	
}
