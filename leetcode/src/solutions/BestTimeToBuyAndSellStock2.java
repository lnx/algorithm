package solutions;

public class BestTimeToBuyAndSellStock2 {

	int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; ++i) {
			profit += Math.max(prices[i] - prices[i - 1], 0);
		}
		return profit;
	}

}
