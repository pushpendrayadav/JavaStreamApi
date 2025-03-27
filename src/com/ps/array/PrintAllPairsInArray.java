package com.ps.array;

public class PrintAllPairsInArray {

	public static void main(String[] args) {
		int [] nums=new int[] {3,5,8,4,7,1};
		printPairs(nums);
	}

	private static void printPairs(int[] nums) {
		int n=nums.length;
		int tp=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				System.out.print("( "+nums[i]+", "+nums[j]+" )");
				tp++;
			}
			System.out.println();
		}
		System.out.println("Total no of Pairs : "+tp);
		
	}

}
