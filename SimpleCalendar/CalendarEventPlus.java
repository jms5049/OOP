package SimpleCalendar;

import java.util.Date;

public class CalendarEventPlus {
	
	Date d = new Date();
	int hours;
	int minutes;
	
	public void setHours(int hours){
		this.d.setHours(hours);
	}
	
	public int getHours(){
		return d.getHours();
	}
	
	
	public void setMinutes(int minutes){
		this.d.setMinutes(minutes);
	}
	
	public int getMinutes(){
		return d.getMinutes();
	}

}
