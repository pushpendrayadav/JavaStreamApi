package com.ps.array;

import java.util.Arrays;

public class FindLargest {

	public static void main(String[] args) {
		int [] nums=new int[] {3,5,8,4,7,1};
		//int [] nums=new int[] {-1,-2,-3,0};
		String item=findLargestItem(nums);
		System.out.println("max Item is :: "+item);
	}

	private static String findLargestItem(int[] nums) {
		int maxItem=Integer.MIN_VALUE;
		int minItem=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			maxItem=Math.max(maxItem, nums[i]);
			minItem=Math.min(minItem, nums[i]);
		}
		return "Max. value is "+maxItem +" min Value is "+minItem;
	}

}
