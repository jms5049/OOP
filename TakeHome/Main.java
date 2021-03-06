package TakeHome;

import java.util.Vector;

public class Main {
	
	public static void main(String[] args) {
		MyCalendar cal = new MyCalendar();
		cal.add(2016, 9, 15, "추석");
		cal.add(2016, 10, 9, "한글날");
		cal.add(2015, 1, 1,"새해");
		cal.add(2018, 5, 5, "어린이날");
		cal.add(2012, 3, 1, "삼일절");
		
		System.out.println("=== Insert ===");
		cal.printCalendar();
		
		System.out.println("\n=== Search ===");		
		cal.search(2016, 10, 9);
		cal.search(2000, 5, 5);
		
		System.out.println("\n=== Delete ===");
		cal.remove(2016,10,9);
		cal.remove(2010,1,1);
		
		System.out.println("\n=== Before Sort ===");
		cal.printCalendar();
		
		System.out.println("\n=== After Sort ===");
		cal.sort();
		cal.printCalendar();		
	}
}
