package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	@RequestMapping("sum/{a}")
	public int twoarrayaddtion(@PathVariable Integer a[]) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		return sum;
	}

	@RequestMapping("sumbodyusiing")
	public int twoarrayaddtionbody(@RequestBody int a[]) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		return sum;
	}

	@RequestMapping("twoarrayaddtion/{b}")
	public int twoarrayaddtion(@RequestBody int a[], @PathVariable int b[]) {
		int sum = 0;

		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		for (int i = 0; i < b.length; i++) {
			sum = sum + b[i];
		}
		return sum;

	}

	@RequestMapping("twoarrayaddtioninclass")
	public int twoarrayaddtionclass(@RequestBody TwoArrays t) {
		int sum = 0;
		int a[] = t.a;
		int b[] = t.b;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		for (int i = 0; i < b.length; i++) {
			sum = sum + b[i];
		}
		return sum;
	}
}
