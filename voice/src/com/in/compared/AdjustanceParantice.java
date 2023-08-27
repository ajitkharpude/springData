package com.in.compared;

import java.util.*;

public class AdjustanceParantice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "[()]{}{[]}";
		String s1="{[}]";
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			list.add(s1.charAt(i));

		}
		while (true) {

			int cnt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == '(' && list.get(i + 1) == ')' || list.get(i) == '[' && list.get(i + 1) == ']'
						|| list.get(i) == '{' && list.get(i + 1) == '}') {
					list.remove(i);
					list.remove(i);
					i--;
					cnt++;
				}
			}
			if(cnt==0)
				break;

		}
		if(list.isEmpty())
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
