package com.ps.array;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int [] nums=new int[] {3,5,8,4,7,1};
		System.out.println("before reverse "+Arrays.toString(nums));
		reverseArray(nums);
		System.out.println("after  reverse "+Arrays.toString(nums));
	}

	private static void reverseArray(int[] nums) {
		int start=0;
		int end=nums.length-1;
		while(start < end) {
			int tmp=nums[end];
			nums[end]=nums[start];
			nums[start]=tmp;
			start++;
			end--;
		}
	}

}
