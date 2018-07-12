
import java.util.Scanner;

public class testShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Burgerking bk = null;
		Scanner input = new Scanner(System.in);
		int i= 0;
		String className = args[0];
		
		try{
			
			bk = (Burgerking) Class.forName(className).newInstance();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		i = input.nextInt();
		bk.purchase(i);
		bk.bill();

	}

}
