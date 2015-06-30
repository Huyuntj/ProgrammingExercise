package com.java.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ProductsPool {
	private static List list = new ArrayList();
//	private static List products = Collections.synchronizedList(list);
	private static int MaxCapacity = 1;
	
	public void put(Object o) throws InterruptedException{
		synchronized(list){
			System.out.println(Thread.currentThread().getName());
			while(list.size() == MaxCapacity){
//				System.out.println("pool is full, please wait!");
				list.wait();
			}
			list.add(o);
			list.notifyAll();			
		}

	}
	
	public Object get() throws InterruptedException{
		synchronized(list){
			System.out.println(Thread.currentThread().getName());
			while(list.size() == 0)
			{
//				System.out.println("pool is empty, please wait!");
				list.wait();	
			}
		
			Object o=list.remove(0);
			list.notifyAll();	
			return o;
		}

	}
//	public static synchronized int size(){
//		
//		return list.size();
//	}
	
	public static void main(String[] args){
		ProductsPool productsPool = new ProductsPool();
		Thread producer = new Thread(new Producer("Producer-1",productsPool));
//		Thread producer2 = new Thread(new Producer("Producer-1",productsPool));
		Thread consumer1 = new Thread(new Consumer("Consumer-1",productsPool));
		producer.start();
//		producer2.start();
		consumer1.start();
//		Thread consumer2 = new Thread(new Consumer("Consumer-2", productsPool));
//		consumer2.start();		
	}
	
}
