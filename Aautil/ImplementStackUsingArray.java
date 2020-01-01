package Basic.Aautil;

import java.util.*;

interface IStack<T>{ //parametrized class
	
	public boolean push(T item);	
	public T pop();
	public int size();
	public boolean contains(T item);
	public void clear();
	public boolean isEmpty();
	
}

class ArrayStack<T> implements IStack<T>{ 
	private static final int INITIAL_CAPACITY = 10;
	private T[] store;
	private int size = 0;
	private int capacity;
	
	public ArrayStack(){
		this.capacity = INITIAL_CAPACITY;
		store = (T[]) new Object[INITIAL_CAPACITY];
	}
	
	@Override
	public boolean push(T item){
		store[size] = item;//array index 0
		size = size + 1;
		return true;
	}
	
	@Override
	public T pop (){
		if (size <= 0){
			return null;
		}
		size = size - 1; //array index 0
		T value = store[size];
		return value;	
	}
	
	@Override
	public int size(){
		return this.size;
	}
	
	@Override
	public boolean contains(T item){
		boolean found = false;
		for(int i = 0; i<this.size;i++){
			T value = store[i];
			if (value.equals(item)){
				found = true;
			}
		}
		return found;
	}
	
	@Override
	public void clear(){
		for(int i=0; i<this.size;i++){
			store[i] = null;
		}
		size = 0;
	}
	
	@Override
	public boolean isEmpty(){
		return this.size == 0;
	}
}

public class ImplementStackUsingArray {

}
