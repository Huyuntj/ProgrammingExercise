
public class MultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new Thread2()).start();
		
		System.out.println("Main Thread is over");
	}

	private static class Thread1 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(MultiThread.class){
				System.out.println("Enter thread1 ....");
				System.out.println("Thread1 is waiting...");
				try {
					MultiThread.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread1 is going on ....");
				System.out.println("Thread1 is over!");
			}
		}
		
	}
	private static class Thread2 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(MultiThread.class){
				System.out.println("Enter thread2 ....");
				System.out.println("Thread2 notify other thread can release wait status...");
				MultiThread.class.notify();
				System.out.println("Thread2 is sleeping ten millisecond...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread2 is going on...");
				System.out.println("Thread2 is over!");
			}
		}
		
	}	
}
