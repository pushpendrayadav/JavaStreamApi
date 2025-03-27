package com.ps.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("jhon");
		list.add("mike");
		list.add("Jake");
		list.add("Brain");

		//convertListOfStringToUpperCase(list);

		String[] ar = new String[] { "abc", "pqr", "xyz" };

		//convertArrayOfStringToUpperCase(ar);
		
		Integer[] nums= {1,2,3,4,5,6,7,8,9};
		//filterEvenNumber(nums);
		
		//sumOfAllNumInList(nums);
		
		String str="Swis";
		
		char ch=getFirstRepeatCharInString(str);
		System.out.println(""+ch);
		
		char ch1=getFirstRepeatCharInStringByStream(str);
		System.out.println(""+ch1);
	}

	//1.1 Convert List of Strings to Uppercase

	private static void convertListOfStringToUpperCase(List<String> list) {
		list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
	}

   //1.2	Convert Array of Strings to Uppercase
	private static void convertArrayOfStringToUpperCase(String[] ar) {
		List<String> list = Arrays.asList(ar);
		convertListOfStringToUpperCase(list);
	}
	
	// 2-Find Even Numbers from a List
	private static void filterEvenNumber(Integer[] ar) {
		List<Integer> list = Arrays.asList(ar);
		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
	}

	// 3-Sum of All Elements in a List
	private static void sumOfAllNumInList(Integer[] ar) {
		List<Integer> list = Arrays.asList(ar);
		Integer sum = list.stream().reduce(Integer::sum).get();
		System.out.println(sum);
	}
	
//	Find the First Repeating Character in a String
	
	private static char getFirstRepeatCharInString(String str) {
		char[] arr=str.toCharArray();
		Map<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		for(char ch:arr) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for(Map.Entry<Character, Integer> pair:map.entrySet()) {
			if(pair.getValue()>1) {
				return pair.getKey();
			}
		}
		
		return 0;
	}
	
	private static char getFirstRepeatCharInStringByStream(String str) {
	Map.Entry<Character, Long> pair	=str.chars().mapToObj(ch->(char)ch)
		.collect(Collectors.groupingBy(ch->ch, LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream()
		.filter(e->e.getValue()>1)
		.findFirst()
		.orElse(null);
		return pair != null ? pair.getKey(): 0 ;
	}

	
}
