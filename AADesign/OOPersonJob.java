package Basic.AADesign;

import java.math.*;

//Composition in java is the design technique to implement has-a relationship in classes
//Java composition is achieved by using instance variables that "refers to other objects". For example, a Person has a Job.

class Job{
	private String role;
	private BigDecimal salary;
	public void setSalary(BigDecimal salary){
		this.salary = salary;
	}
	public BigDecimal getSalary(){
		return this.salary;
	}
}
class Person{
	private Job job; //Person has-a job.
	public Person(){
		this.job = new Job();
		job.setSalary(BigDecimal.valueOf(1000));
	}
	public BigDecimal getSalary(){
		return job.getSalary();
	}
}
public class OOPersonJob {

	public static void main(String[] args) {
		Person p = new Person();
		BigDecimal salary = p.getSalary();
		System.out.println("Salary : " + salary);
	}

}
