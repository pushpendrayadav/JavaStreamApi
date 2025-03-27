package com.ps.array;

public class PrintAllSubArray {

	public static void main(String[] args) {
		int [] nums=new int[] {3,5,8,4,7,1};
		printAllSubArray(nums);
	}

	private static void printAllSubArray(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print( + nums[k]);
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
