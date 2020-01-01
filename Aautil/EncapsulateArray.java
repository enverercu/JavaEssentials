package Basic.Aautil;

import java.util.*;

class MyArray<T>{
	private static final int INITIAL_CAPACITY = 5;
	private T[] store;
	private int size = 0;
	
	public MyArray(){
		store = (T[]) new Object[INITIAL_CAPACITY];
	}
	
	public boolean add(T item){
		if (this.size >= store.length){
			int newSize = this.size + 5;
			store = Arrays.copyOf(store, newSize);
			System.out.println("array is resizing to..." + newSize);
		}
		store[size] = item;
		size = size + 1;
		
		return true;
	}
}

public class EncapsulateArray {

	public static void main(String[] args){
		
		MyArray<Integer> array = new MyArray<>();
		
		for(int i = 0; i < 20; i++){
			array.add(i);
		}
		
	}
}
