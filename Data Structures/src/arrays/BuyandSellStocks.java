package arrays;

/*
 * Given an array whose indices are days and values are price values of every stock on each day.
 * Find the day when you would buy the stock and sell the stock based on gaining max profit 
 * 
 * */
public class BuyandSellStocks {

	public static int findMaxProfit(int arr[]){
		int buyIndex=0;
		int sellIndex =0;
		
		int min= arr[0];
		int maxProfit = Integer.MIN_VALUE;
		for(int i=1; i<arr.length; i++){
			int profit = arr[i] - min ;
			if(profit > maxProfit){
				sellIndex = i;
				maxProfit = profit;
			}	
			if(arr[i] < min && i<=sellIndex){
				buyIndex = i;
				min = arr[i];
			}
		}
		System.out.println("The buy index is: " + buyIndex);
		System.out.println("The sell index is: " + sellIndex);
		return maxProfit;
					
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {100,10,2,6,12,20,1};
		
		int profitMAx = findMaxProfit(arr);
		System.out.println(profitMAx);
	}

}
