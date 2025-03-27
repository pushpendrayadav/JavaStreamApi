package com.ps.array;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		
		int [] nums=new int[] {3,5,8,4,7,1};
		int item=1;
		//to apply binary search arry should be sorted.
		Arrays.sort(nums);
		int index=binarySearch(nums,item);
		System.out.println("found at index :: "+index);

	}

	private static int binarySearch(int[] nums, int item) {
		int start=0; 
		int end=nums.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(nums[mid]==item) {
				return mid;
			}else if(nums[mid]<item) {
				start++;
			}else {
				end--;
			}
			
		}
		return -1;
	}

}
