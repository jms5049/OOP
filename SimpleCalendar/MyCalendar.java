package SimpleCalendar;

import java.util.StringTokenizer;

public class MyCalendar {

	CalendarEvent c = new CalendarEvent();
	CalendarEvent[] cEvent;

	int size = 100;
	int i = 0;

	public MyCalendar() {
		cEvent = new CalendarEvent[size];
	}

	public void add(int year, int month, int date, String event) {

		cEvent[i] = new CalendarEvent();
		cEvent[i].setYear(year);
		cEvent[i].setMonth(month);
		cEvent[i].setDate(date);
		cEvent[i].setEvent(event);
		i++;

	}	
	
	
}
