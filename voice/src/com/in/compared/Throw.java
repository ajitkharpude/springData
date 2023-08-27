package com.in.compared;

public class Throw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			run();
		
	}

	private static void run() {
		// TODO Auto-generated method stub
		if (18 < 20){

			try {
				throw new Inviled("outage");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("handeld");
			}
		}
	}
}

class Inviled extends Exception{

	public Inviled() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inviled(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public Inviled(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public Inviled(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Inviled(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
