package Basic.Aautil;

class Employee{
	private int id;
	private String name;
	
	public Employee(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.id + " - " + this.name;
	}
}

class SinglyLinkedList<T>{
	
	private static class Node<T>{//java replace T with Object

		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
		
		@Override
		public String toString(){
			return this.data.toString();
		}
	}
	
	
	private Node head; //head is the first node in linked list
	private Node tail;
	
	public void append(T data){
		
		Node newNode = new Node(data);  
		
		if (head==null){
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;//newNode will be added after tail such that tail's next will point to newNode
			tail = newNode; //newNode will become new tail of the list 
		}
		
		
	}
	
	public void reverse(){
		
		Node current = head;
		Node previous = null;
		Node forward = null;
		
		// traversing linked list until there is no more element
		while (current.next != null){
			
			// Saving reference of next node, since we are changing current node
			forward = current.next;
			
			// Inserting node at start of new list
			current.next = previous;
			previous = current;
			
			// Advancing to next node
			current = forward;
		}
		
		head = current;
		head.next = previous;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current != null){
			sb.append(current).append("-->");
			current = current.next;
		}
		return sb.toString();
	}
}


public class ReverseLinkedList {

	public static void main(String[] args){
		
		printSecondTest();
	}
	
	public static void printFirstTest(){
		
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.append("A");
		linkedList.append("B");
		linkedList.append("C");
		
		System.out.println(linkedList);
		
		linkedList.reverse();
		
		System.out.println(linkedList);
	}
	
	public static void printSecondTest(){
		
		SinglyLinkedList<Employee> linkedList = new SinglyLinkedList<Employee>();
		linkedList.append(new Employee(1,"Enver"));
		linkedList.append(new Employee(2,"Yilmaz"));
		
		System.out.println(linkedList);
		
		linkedList.reverse();
		
		System.out.println(linkedList);
	}
}
