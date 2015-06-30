package com.java.thread.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue<Integer> sharedQueue;
	
	public Consumer(BlockingQueue<Integer>  sharedQueue){
		this.sharedQueue = sharedQueue;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			try {
				System.out.println("Consumed: "+ sharedQueue.take());
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
		}

	}

}
