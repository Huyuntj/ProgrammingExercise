package com.java.thread;

public class Consumer implements Runnable{
	private String name;
	private ProductsPool pool;
	
	public Consumer(String name, ProductsPool pool){
		this.name = name;
		this.pool = pool;
	}
	
	public void run(){
		for(int i = 0; i < 10; i++){
//			System.out.println("Consumer: "+i);
			try {
				pool.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
					
		}	

	}
	

}
