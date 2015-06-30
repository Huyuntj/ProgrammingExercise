package com.java.thread;

public class GeneralInterrupt extends Object implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralInterrupt gi = new GeneralInterrupt();
		Thread thread = new Thread(gi);
		thread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in main() - interrupting other thread");
		thread.interrupt();		
		System.out.println("in main() - leaving");
	}

	@Override
	public void run() {
		try {
			System.out.println("in run() -  about to work()");			
			work();
			System.out.println("in run() -  back from work()");					

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return;
		}
	    System.out.println("in run() - doing stuff after nap");
	    System.out.println("in run() - leaving normally");		
	}
	public void work() throws InterruptedException{
		while (true) {
         if (Thread.currentThread().isInterrupted()) {
            System.out.println("C isInterrupted()="
            + Thread.currentThread().isInterrupted());
            Thread.sleep(2000);
            System.out.println("D isInterrupted()="
            + Thread.currentThread().isInterrupted());
         }
      }
	}
}
