package SimpleCalendar;

public class TestCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCalendar c = new MyCalendar();
		
		c.add(2016, 10, 3, "개천절");
		c.add(2016, 10, 9, "한글날");
		c.add(2016, 10, 25, "컴퓨터구조 중간고사 시험");
		c.add(2016, 10, 28, "객체지향설계 중간고사 시험");	
		
		
		System.out.println("Simple Calendar");
		c.print();
		System.out.println();
		
		c.delete(2016, 10, 9);
		
		System.out.println("PrintEvent");
		c.printEvent(2016, 10, 3);
		c.printEvent(2016, 10, 9);
		c.printEvent(2016, 10, 25);
		c.printEvent(2016, 10, 28);
		System.out.println();
		
		c.printMatchEvent("시험");
		

	}

}
