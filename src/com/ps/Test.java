package com.ps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<Emp> empList=new ArrayList<Emp>();
		empList.add(new Emp("Jake", 2000));
		empList.add(new Emp("Mike", 3000));
		empList.add(new Emp("Joe", 5000));
		empList.add(new Emp("Mc", 6000));
		
		Integer secondHighest=
				empList.stream().map(e->e.salary()).sorted(Comparator.reverseOrder())
				.skip(1).findFirst().get();
		
		System.out.println(secondHighest);
		
		// get whole employee details
		
		Emp e=empList.stream().sorted(Comparator.comparingInt(Emp::salary).reversed()).skip(1).findFirst().get();

		System.out.println(e);
		
	}

}
