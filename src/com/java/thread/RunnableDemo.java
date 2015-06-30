package com.java.thread;

public class RunnableDemo implements Runnable {
	//private Thread thread;
	private String threadName;
	private int total;
	public int getTotal(){
		return this.total;
	}
	public RunnableDemo(String name){
		this.threadName = name;
		System.out.println("Creating " +  threadName );
	}
//	@Override
//	public void run() {
//		System.out.println("Running " +  threadName );
//	      try {
//	         for(int i = 4; i > 0; i--) {
//	            System.out.println("Thread: " + threadName + ", " + i);
//	            // Let the thread sleep for a while.
//	            Thread.sleep(50);
//	         }
//	     } catch (InterruptedException e) {
//	         System.out.println("Thread " +  threadName + " interrupted.");
//	     }
//	     System.out.println("Thread " +  threadName + " exiting.");
//	}
	
	public void run(){
		for(int i = 0; i< 100; i++){
			total += i;
		}
	}
	public static void main(String[] args){
		RunnableDemo rd = new RunnableDemo("Thread - 1");
		Thread thread = new Thread(rd);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rd.getTotal());
	}

//	public void start(){
//		System.out.println("Starting " +  threadName );
//		Thread thread = new Thread(this, threadName);
//		thread.start();
//	}

}
