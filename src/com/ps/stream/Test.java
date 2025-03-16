package com.ps.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("jhon");
		list.add("mike");
		list.add("Jake");
		list.add("Brain");

		convertListOfStringToUpperCase(list);

		String[] ar = new String[] { "abc", "pqr", "xyz" };

		convertArrayOfStringToUpperCase(ar);
	}

	// Convert List of Strings to Uppercase

	private static void convertListOfStringToUpperCase(List<String> list) {
		list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
	}

//	Convert Array of Strings to Uppercase
	private static void convertArrayOfStringToUpperCase(String[] ar) {
		List<String> list = Arrays.asList(ar);
		convertListOfStringToUpperCase(list);
	}

}
