package Basic.HashCode;

public class User {

	private long id;
	private String name;
	
	public User(long id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode(){
		//return 1; //Even more, there's nothing illegitimate with having hashCode() returning any fixed value.
				  //However, this implementation degrades the functionality of hash tables to basically zero, 
				  //as every object would be stored in the same, single bucket.	
		int hash = 7;
		hash = (int) (31 * 7 + (id * name.hashCode()));
		System.out.println("hash code:" + hash);
		return hash;
		
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;
		User user = (User) o;
		if (this.id == user.id && this.name == user.name)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString(){
		return this.id + " - " + this.name;
	}
}
