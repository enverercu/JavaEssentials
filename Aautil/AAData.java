package Basic.Aautil;

public class AAData {

	//SET : unique
	//TREE : sorted
	//Linked : insertion order preserves
	//MAP<K,V> : key
	//SET<T> : index
	//LIST<T> : index
	
	//[SET]
	//Set<T> : It is an unordered collection of objects in which duplicate values cannot be stored.
	
	//HashSet<T> : duplicate values are not allowed.
	//Objects that you insert in HashSet are not guaranteed to be inserted in same order. Objects are inserted based on their hash code.
	//NULL elements are allowed in HashSet.
	//HashSet h = new HashSet(Collection C);
	
	//LinkedHashSet<T> : LinkedHashSet is an insertion ordered version of HashSet.
	//LinkedHashSet lets us iterate through the elements in the order in which they were inserted
	//Contains unique elements only like HashSet.
	//HashSet h = new LinkedHashSet(Collection C); Used in initializing the LinkedHashSet with the elements of the collection C
	
	//TreeSet<T> (sorted representation): uses a Tree for storage.
	//Tree: duplicate values are not allowed.
	//Objects in a TreeSet are stored in a sorted and ascending order.
	//The ordering of the elements is maintained by a set using their natural ordering. hem unique hem sorted.
	//It can also be ordered by a Comparator provided at set creation time, depending on which constructor is used.
	//TreeSet t = new TreeSet(Comparator comp);
	//TreeSet serves as an excellent choice for storing large amounts of sorted information which are supposed to be accessed quickly because of its faster access and retrieval time.
	
	//[MAP]
	//HashMap<K,V> : no insertion order. key unique. second same key overwrite previous.
	//HashMap allows one null key and any number of null values
	//In HashMap the elements is being fetched by specifying the corresponding key
	
	//LinkedHashMap<K,V> : same as HashMap + preserves the insertion order.
	//key unique
	
	//TreeMap<K,V> : Tree nature it is sorted by key, or by a Comparator provided at map creation time
	//TreeMap<Student, Integer> tree_map = new TreeMap<Student, Integer>(new Sortbyroll()); sortbyroll:comparator
	//Tree nature, key is unique. second same key overwrites previous.
	//This proves to be an efficient way of sorting and storing the key-value pairs
	//TreeMap(Map m) : Initializes a tree map with the entries from m, which will be sorted by using the natural order of the keys.
	//TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>(hash_map); --> hashmap içeriðini sortlu olarak depolar
	//Red-Black Tree:log(n)
	
	//[LIST]
	//ArrayList<T> : ArrayList maintains the insertion order.ArrayList returns the list items in the same order in which they got inserted into the list
	//ArrayList allows duplicate elements.
	//ArrayList can have any number of null elements.
	//In ArrayList we can get the element by specifying the index of it.
	
	//LinkedList<T> : not stored in contiguous locations and every element is a separate object with a data part and address part
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
