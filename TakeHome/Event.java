package TakeHome;

import java.util.*;

public class Event {

	Date d = new Date();
	Pair<Date, String> event;
	int year, month, date;

	public Event(int year, int month, int date, String value) {

		event = new Pair<Date, String>(); 
		d.setYear((year));
		d.setMonth((month));
		d.setDate(date);
		event.setKey(d);
		event.setValue(value);
	}

	public String toString() {
		Date d = event.getKey();
		int year = d.getYear();
		int month = d.getMonth();
		int date = d.getDate();
		return year + "year " + month + "month " + date + "day: " + event.getValue();

	}
}
