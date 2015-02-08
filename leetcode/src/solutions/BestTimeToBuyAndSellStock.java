package solutions;

public class BestTimeToBuyAndSellStock {

	int maxProfit(int[] prices) {
		int ret = 0;
		for (int i = 0, min = Integer.MAX_VALUE; i < prices.length; ++i) {
			if (prices[i] > min) {
				ret = Math.max(prices[i] - min, ret);
			} else {
				min = prices[i];
			}
		}
		return ret;
	}

}
