package solutions;

public class BestTimeToBuyAndSellStock3 {

	int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int[] p1 = new int[prices.length];
		for (int i = 1, min = prices[0]; i < prices.length; ++i) {
			min = Math.min(min, prices[i]);
			p1[i] = Math.max(p1[i - 1], prices[i] - min);
		}
		int[] p2 = new int[prices.length];
		for (int i = prices.length - 2, max = prices[prices.length - 1]; i >= 0; --i) {
			max = Math.max(max, prices[i]);
			p2[i] = Math.max(p2[i + 1], max - prices[i]);
		}
		int profit = 0;
		for (int i = 0; i < prices.length; ++i) {
			profit = Math.max(profit, p1[i] + p2[i]);
		}
		return profit;
	}

}
