package com.ps.array;

public class MaxSumSubArray {

	public static void main(String[] args) {
		int [] nums=new int[] {3,5,8,4,7,1};
		//int [] nums=new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
		//int [] nums=new int[] {-1, -2, -3, -4};
		//printMAxSumOfSubArrayBruteForce(nums);
		printMAxSumOfSubArrayUsingPrefixSum(nums);
		findMaxSumOfSubArraysUsingKadanesAlgo(nums);
	}

	private static void printMAxSumOfSubArrayBruteForce(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
       // int currentSum=0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int arraySum=0;
				for (int k = i; k <= j; k++) {
					System.out.print( + nums[k]);
					arraySum=arraySum+nums[k];
				}
				maxSum=Math.max(maxSum, arraySum);
				System.out.println("sum "+arraySum);
				System.out.println();
			}
			
		}
		System.out.println("Max SubArray Sum is : "+maxSum);
			
	}
	
	
	//formula using prefixSum method we can save 3rd Inner loop 
	//by using formula subArraySum=prefixSum[j]-prefixSum[i-1]; 
	//but In this case we need some extra memory to hold prefixsum
	
	private static void printMAxSumOfSubArrayUsingPrefixSum(int[] nums) {
		int n = nums.length;
        int maxSum=Integer.MIN_VALUE;
       // int currentSum=0;
        
        int [] prefixSum=new int[n];
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++) {
        	prefixSum[i]=nums[i]+prefixSum[i-1];
        }
        
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int arraySum=i==0 ? prefixSum[j] : prefixSum[j]-prefixSum[i-1];
//				for (int k = i; k <= j; k++) {
//					System.out.print( + nums[k]);
//					arraySum=arraySum+nums[k];
//				}
				maxSum=Math.max(maxSum, arraySum);
				System.out.println("sum "+arraySum);
				System.out.println();
			}
			
		}
		System.out.println("Max SubArray Sum is : "+maxSum);
			
	}
	
	private static void findMaxSumOfSubArraysUsingKadanesAlgo(int[] nums) {
		int maxSum=Integer.MIN_VALUE;
		int currentSum=0;
		for(int i=0;i<nums.length;i++) {
			currentSum+=nums[i];
			maxSum=Math.max(maxSum, currentSum);
			if(currentSum<0) {
				currentSum=0;
			}
		}
		System.out.println(maxSum);
		
	}
	

}
