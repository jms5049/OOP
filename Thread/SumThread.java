package thread;

public class SumThread extends Thread{

	int number;
	int name;
	int result;
		
	public SumThread(){
		
	}
	
	public SumThread(int name,int number){
		this.name = name; 
		this.number = number; 
	}
	
	public int getSum(){
		return result; 
	}

	
}
