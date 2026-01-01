package leetcode;

public class StockBestTime {
	public static void main(String args[])	{
		int prices[] = {10,8,7,5,2};
		maxProfit(prices);
	}
	public static int maxProfit(int prices[])	{
		int minPrice = Integer.MAX_VALUE, maxProfit = 0;
		for (int price : prices)	{
			minPrice = Integer.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		return maxProfit;
	}
}
