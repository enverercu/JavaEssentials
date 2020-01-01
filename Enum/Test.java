package Basic.Enum;

enum DaysOfWeekEnum {
    SUNDAY,
    MONDAY,
    TUESDAY, 
    WEDNESDAY, 
    THURSDAY, 
    FRIDAY, 
    SATURDAY
}

public class Test {

	public static void main(String[] args) {
		
		for (DaysOfWeekEnum day : DaysOfWeekEnum.values()) { 
		    System.out.println(day); 
		}

	}

}
