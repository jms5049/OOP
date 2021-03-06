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
	
	public void delete(int year, int month, int date) {

		for (int k = 0; k < i; k++) {
			if (cEvent[k].getYear() == year && cEvent[k].getMonth() == month && cEvent[k].getDate() == date) {

				cEvent[k] = null;
				System.arraycopy(cEvent, k+1, cEvent, k, i-k);
				--i;
			}
			
		}

	}

	public void printEvent(int year, int month, int date) {
		for (int k = 0; k < i; k++) {
			if (cEvent[k].getYear() == year && cEvent[k].getMonth() == month && cEvent[k].getDate() == date) {
				System.out.println(cEvent[k].getYear() + "," + cEvent[k].getMonth() + "," + cEvent[k].getDate()+ "의 일정->\t "+cEvent[k].getEvent());
			}
		}

	}

	public void print(){
		
		for (int k = 0; k<i; k++){
			System.out.println(cEvent[k].getYear() + "," + cEvent[k].getMonth() + "," + cEvent[k].getDate()+ " "
							+ cEvent[k].getEvent());
		}
		
	}
	public void printMatchEvent(String event) {

		for (int k = 0; k < i; k++) {
			StringTokenizer parser = new StringTokenizer(cEvent[k].getEvent(), " ,:;-?1");
			while (parser.hasMoreTokens()) {
				String word = parser.nextToken();
				if (word.equals(event)) {
					System.out.print("'" +event+ "'" + "contain Schedule :\t");
					System.out.println(cEvent[k].getYear() + "," + cEvent[k].getMonth() + "," + cEvent[k].getDate()+ " - "
							+ cEvent[k].getEvent());
				}

			}
		}

	}

	
	
	
	
}
