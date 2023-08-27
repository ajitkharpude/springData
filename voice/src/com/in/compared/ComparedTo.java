package com.in.compared;

import java.util.Comparator;

public class ComparedTo implements Comparator<Emp2> {

	@Override
	public int compare(Emp2 o1, Emp2 o2) {
		// TODO Auto-generated method stub
		
		if(o1.id==o2.id)
			
			return o1.name.compareTo(o2.name);
		else if(o1.id<o2.id)
			return -1;
		else
		return 1;
	}

}
