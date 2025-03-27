package com.ps.array;

public class BestTimeBuySellStock {

	public static void main(String[] args) {
		//int [] prices=new int [] {7, 1, 5, 3, 6, 4};
		//int [] prices=new int [] {1, 2, 3, 4, 5};
		int [] prices=new int [] {3};
		int profit=findProfitBuySellStockOnce(prices);
		System.out.println("Profit : "+profit);

	}

	private static int findProfitBuySellStockOnce(int[] prices) {
		int profit=Integer.MIN_VALUE; //profit=sp-buyPrice;
		int sellPrice=0;
		int buyPrice=prices[0];
		for(int i=1;i<prices.length;i++) {
			sellPrice=prices[i];
			profit=Math.max(profit,sellPrice-buyPrice);
			if(profit<0) {
				buyPrice=sellPrice;
			}
		}
		
		return profit <0 ? 0 : profit;
	}
	
	// refactored version
	
	private static int maxProfitSingleTransaction(int[] prices) {
	    if (prices == null || prices.length < 2) {
	        return 0; // No profit possible
	    }

	    int profit = 0; // Minimum profit should be 0 (no transaction)
	    int buyPrice = prices[0];

	    for (int i = 1; i < prices.length; i++) {
	        // Calculate profit if we sell at current price
	        profit = Math.max(profit, prices[i] - buyPrice);

	        // Update buyPrice if we find a lower price
	        buyPrice = Math.min(buyPrice, prices[i]);
	    }

	    return profit;
	}


}
