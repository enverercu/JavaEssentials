package Basic.Aautil;

import java.util.*;

public class CommonElementsOfTwoArrays
{
	public static void main(String[] args) {
        
       int[] arr1 = {1,2,3,4,5,6,7};
       int[] arr2 = {2,4,5,1};
       
       Set<Integer> set = new HashSet<Integer>();
       Set<Integer> newSet = new HashSet<Integer>();
       for(int i:arr1){
           set.add(i);
       }
       for(int i:arr2){
           if(!set.add(i)){
               newSet.add(i);
           }
       }
       for(int i:newSet){
           System.out.println(i);
       }
      
	}

}
