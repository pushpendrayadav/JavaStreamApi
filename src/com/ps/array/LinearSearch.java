package com.ps.array;

public class LinearSearch {

	public static void main(String[] args) {
		
		int [] nums=new int[] {3,5,8,4,7,1};
		int item=1;
		
		int index=linearSearch(nums,item);
		System.out.println("found at index :: "+index);

	}

	private static int linearSearch(int[] nums,int item) {
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==item) {
				return i; 
			}
		}
		
		return -1;
	}

}
