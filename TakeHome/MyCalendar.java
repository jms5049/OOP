package TakeHome;

import java.util.*;

public class MyCalendar {

	Event event;
	int size = 0;
	ArrayList<Event> array = new ArrayList<Event>(100);
	public MyCalendar() {

	}

	public void add(int year, int month, int date, String value) {
		event = new Event(year, month, date, value); 							
		array.add(event); 
		size++; 
	}

	public void search(int year, int month, int date) {

		Date d = new Date(); 
		d.setYear(year);
		d.setMonth(month); 
		d.setDate(date); 

		Iterator<Event> iterator = array.iterator();
		while (iterator.hasNext()) {
			Event object = (Event) iterator.next();
													
			if (object.d.getYear() == d.getYear() && object.d.getMonth() == d.getMonth()
					&& object.d.getDate() == d.getDate()) { 					

				System.out.println(object.event.getValue()); 
				break;

			}
			if (!iterator.hasNext() && object.d.getYear() != d.getYear()) {										
																			
				System.out.println("Nothing Found");
			}
		}
	}

	public void remove(int year, int month, int date) {
		Date d = new Date();
		d.setYear(year);
		d.setMonth(month);
		d.setDate(date);

		Iterator<Event> iterator = array.iterator();
		while (iterator.hasNext()) {
			Event object = (Event) iterator.next();
													
			if (object.d.getYear() == d.getYear() && object.d.getMonth() == d.getMonth()
					&& object.d.getDate() == d.getDate()) { 						

				System.out.println(object.event.getValue() + " Deleted");
				array.remove(object);
				break;

			}
			if (!iterator.hasNext() && object.d.getYear() != d.getYear()) { 
																			
																			
																			
				System.out.println("Nothing to Delete");
			}
		}
	}

	public void sort() {

		Collections.sort(array, new Comparator<Event>() {
			@Override
			public int compare(Event alpha, Event beta) {
				// TODO Auto-generated method stub
				if (alpha.d.getYear() > beta.d.getYear()) { 
															
					return -1;
				} else if (alpha.d.getYear() < beta.d.getYear()) {
					return 1;
				} else {
					if (alpha.d.getMonth() > beta.d.getMonth())
						return -1;
					else if (alpha.d.getMonth() < beta.d.getMonth()) {
						return 1;
					} else {
						if (alpha.d.getDate() > beta.d.getDate())
							return -1;
						else {
							return 1;
						}
					}
				}
			}
		});
	}

	public void printCalendar() {

		Iterator<Event> iterator = array.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println(object);
		}

	}

}
