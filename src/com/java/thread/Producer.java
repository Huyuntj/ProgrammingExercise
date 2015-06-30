package com.java.thread;

public class Producer implements Runnable{
	private String name;
	private ProductsPool pool;
	
	public Producer(String name, ProductsPool pool){
		this.name = name;
		this.pool = pool;
	}
	

	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
//			System.out.println("Producer: "+i);
			try {
				pool.put(new Object());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
