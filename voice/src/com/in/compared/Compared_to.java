package com.in.compared;

import java.util.Iterator;

public class Compared_to implements Runnable{

	@Override
	public void run() {
		Object mutex = 0;
		// TODO Auto-generated method stub
		synchronized (mutex) {
			
			System.out.println(Thread.currentThread().isDaemon());
		for (int i = 0; i < 10; i++) {
			System.out.print(Thread.currentThread()+" :");
			System.out.println(i);}
		}
		System.out.println();
	}
	
		
	

}
