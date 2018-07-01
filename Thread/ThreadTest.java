package thread;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException{
		long start, end;
		
		
		ThreadManager tm = new ThreadManager();
		tm.createThread(100,5);
		System.out.println("1부터 100까지 합: " + tm.getSumOfNum());
		
		System.out.println("=== N과 M의 값에 따른 실행시간 측정 ===");
		for(long N = 16; N <=300000000; N*=4){ 	
			for(int M =1; M<=16; M*=2){ 
				tm.createThread(N, M);
				
				start = System.nanoTime();
				tm.getSumOfNum();
				end = System.nanoTime();
				
				System.out.printf("%9d\t", end-start);
			}
			System.out.println();
		}
	}

}
