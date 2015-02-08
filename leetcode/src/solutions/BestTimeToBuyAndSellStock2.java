package solutions;

public class BestTimeToBuyAndSellStock2 {

	int maxProfit(int[] prices) {
		int ret = 0;
		for (int i = 1; i < prices.length; ++i) {
			if (prices[i] > prices[i - 1]) {
				ret += prices[i] - prices[i - 1];
			}
		}
		return ret;
	}

}
