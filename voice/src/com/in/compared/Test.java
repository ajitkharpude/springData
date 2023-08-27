package com.in.compared;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread());

Compared_to c=new Compared_to();
Thread t1=new Thread(c);
t1.start();
Thread t2=new Thread(c);
t2.start();
Thread t3=new Thread(c);
t3.start();
	}

}
