package com.ps.array;

import java.util.Arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		
		//int [] hieghts=new int [] {3, 0, 2, 0, 4};
		//int [] hieghts=new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
		//int [] hieghts=new int [] {1, 2, 3, 4, 5};
		//int [] hieghts=new int [] { 5,4,3,2,1};
		//int [] hieghts=new int [] { 2,5};
		int [] hieghts=new int [] {4, 2, 0, 3, 2, 5};
		
		int water=caculateTrappedWater(hieghts);
		System.out.println("Total Water : "+water);

	}

	private static int caculateTrappedWater(int[] hieghts) {
		
		//create leftMax AuxiArray
		//create rightMax AuxiArray
		// trappedwater+=MIN(leftMax[i],rightMAx[i])-hieght[i];
		int n=hieghts.length;
		int [] leftMax=new int [n];
		int [] rightMax=new int [n];
		leftMax[0]=hieghts[0];
		rightMax[n-1]=hieghts[n-1];
		for(int i=1;i<n;i++) {
			leftMax[i]=Math.max(leftMax[i-1], hieghts[i]);
		}
		
		for(int i=n-2;i>=0;i--) {
			rightMax[i]=Math.max(rightMax[i+1], hieghts[i]);
		}
		int trappedwater=0;
		System.out.println(Arrays.toString(hieghts));
		System.out.println(Arrays.toString(leftMax));
		System.out.println(Arrays.toString(rightMax));
		
		for(int i=0;i<n;i++) {
			trappedwater+=Math.min(leftMax[i],rightMax[i])-hieghts[i];
		}
		
		
		return trappedwater;
	}

}
