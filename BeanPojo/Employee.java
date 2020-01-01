package Basic.BeanPojo;
//POJOs basically defines an entity. 
//Like in you program, if you want a Employee class then you can create a POJO as follows:
//no extend,no implement, no annotation
//As you can see, there is no restriction on access-modifier of fields. 
//They can be private, default, protected or public. It is also not necessary to include any constructor in it.
public class Employee 
{ 
    // default field 
    String name; 
  
    // public field 
    public String id; 
  
    // private salary x
    private double salary; 
  
    //arg-constructor to initialize fields 
    public Employee(String name, String id,  
                             double salary) 
    { 
        this.name = name; 
        this.id = id; 
        this.salary = salary; 
    } 
  
    // getter method for name 
    public String getName() 
    { 
        return name; 
    } 
  
    // getter method for id 
    public String getId() 
    { 
        return id; 
    } 
  
    // getter method for salary 
    public Double getSalary() 
    { 
        return salary; 
    } 
} 