package SimpleCalendar;

import java.util.*;

public class CalendarEvent extends CalendarEventPlus{
	
	Date d = new Date();
	String event;
	int year;
	int month;
	int date;
	
	public CalendarEvent(){	
	
	}
	
	public void setYear(int year){
		this.d.setYear(year);
	}
	
	public int getYear(){
		return d.getYear();
	}
	
	public void setMonth(int month){
		this.d.setMonth(month);
	}
		
	public int getMonth(){
		return d.getMonth();
	}
	
	public void setDate(int date){
		this.d.setDate(date);
	}
	
	public int getDate(){
		return d.getDate();
	}
	
	public void setEvent(String event){
		this.event = event;
	}
	
	public String getEvent(){
		return this.event;
	}

	
	
}
