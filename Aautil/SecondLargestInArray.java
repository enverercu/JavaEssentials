package Basic.Aautil;

import java.util.*;

public class SecondLargestInArray
{
    
	public static void main(String[] args) {
        
        int[] arr = {33,56,89,11,44,9,2,66,78};
        int largest = arr[0];
        int secondLargest = arr[0];
        
        for(int i=1;i<arr.length;i++){
            
            if (arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secondLargest){
                secondLargest = arr[i];
            }
            
        }
        
        System.out.println("largest:" + largest);
        System.out.println("second largest:" + secondLargest);
      
	}

}
