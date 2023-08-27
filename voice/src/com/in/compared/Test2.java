package com.in.compared;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Employees e=new Employees(1, "lsllk");
//		Employees e2=new Employees(3, "gd");
//		Employees e3=new Employees(2, "ak");
		
		Emp2 e1=new Emp2(1,"ajit");
		Emp2 e2=new Emp2(3,"ak");
		Emp2 e3=new Emp2(1,"aa");
		Emp2 a[]= {e1,e2,e3};
		Arrays.sort(a,new ComparedTo());
		for (Emp2 employees : a) {
			System.out.println(employees);
		}

	}

}
