package thread;

public class ThreadManager {

	Thread[] ta;
	int size;
	int result;

	public ThreadManager() {

	}

	public void createThread(long n, int m) {
		this.size = m;
		ta = new Thread[size];
		
		if (n % m == 0) {
			int range = (int) n / m; 
			for (int i = 0; i < m; i++) { 
				ta[i] = new SumThread(i, range);
				}
		}
		else{
			System.out.println("ERROR : No. of Threads should be even");
		}

	}

	public int getSumOfNum() {

		for (int i = 0; i < size; i++) {
			ta[i].start(); 
			try {
				ta[i].join(); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = result + ((SumThread) ta[i]).getSum();
			}

		return result;
	}

}
