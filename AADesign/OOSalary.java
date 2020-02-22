package Basic.AADesign;
//OVERRIDING
class Employees { 
	 public static int base = 10000; 
	 int salary() { 
	     return base; 
	 } 
} 
class Manager extends Employees { 
	int salary(){ 
     return base + 20000; 
	} 
} 
class Clerk extends Employees { 
	int salary(){ 
     return base + 10000; 
	} 
} 
class OOSalary { 
 static void printSalary(Employees e){ 
     System.out.println(e.salary()); 
 } 

 public static void main(String[] args) 
 { 
     Employees obj1 = new Manager(); 
     printSalary(obj1); 
     Employees obj2 = new Clerk(); 
     printSalary(obj2); 
 } 
} 
