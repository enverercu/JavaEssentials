package Basic.Comparable.Comparator;

import java.util.Comparator;

class StudentNameComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2){
		return o1.getStudentname().compareTo(o2.getStudentname());
	}
}

class StudentAgeComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2){
		return o1.getStudentage()-o2.getStudentage();
	}
}

public class Student {

	private String studentname;
    private int rollno;
    private int studentage;
    
    public Student(int rollno, String studentname, int studentage) {
        this.rollno = rollno;
        this.studentname = studentname;
        this.studentage = studentage;
    }
    
    /*Comparator for sorting the list by Student Name*/
    public static Comparator<Student> StuNameComparator = new Comparator<Student>() 
    {

		public int compare(Student s1, Student s2) {
		   String StudentName1 = s1.getStudentname().toUpperCase();
		   String StudentName2 = s2.getStudentname().toUpperCase();
	
		   //ascending order
		   return StudentName1.compareTo(StudentName2);
	
		   //descending order
		   //return StudentName2.compareTo(StudentName1);
	    }
	};
    
    /*Comparator for sorting the list by roll no*/
    public static Comparator<Student> StuRollno = new Comparator<Student>() {

		public int compare(Student s1, Student s2) {
	
		   int rollno1 = s1.getRollno();
		   int rollno2 = s2.getRollno();
	
		   /*For ascending order*/
		   return rollno1-rollno2;
	
		   /*For descending order*/
		   //rollno2-rollno1;
		}
	};
   
   @Override
   public String toString() {
       return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
   }

	public String getStudentname() {
		return studentname;
	}
	
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	public int getRollno() {
		return rollno;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public int getStudentage() {
		return studentage;
	}
	
	public void setStudentage(int studentage) {
		this.studentage = studentage;
	}
   
   
}
