package Basic.Aautil;

import java.util.*;

public class SortMapByValue
{
    static class sortByValue implements Comparator<Map.Entry<Integer,String>>{
        @Override
        public int compare(Map.Entry<Integer,String> o1 , Map.Entry<Integer,String> o2){
            return o1.getValue().compareTo(o2.getValue());
        }
    }
    
	public static void main(String[] args) {
        
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"julia");
        map.put(99,"andy");
        map.put(3,"mary");
        List <Map.Entry<Integer,String>> list = new ArrayList<Map.Entry<Integer,String>>(map.entrySet());
        
        Collections.sort(list,new sortByValue());
        
        Map<Integer,String> newMap = new LinkedHashMap<Integer,String>();
        for(Map.Entry<Integer,String> entry:list){
            newMap.put(entry.getKey(),entry.getValue());
        }
        
        for(Map.Entry<Integer,String> entry:newMap.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }

	}

}
