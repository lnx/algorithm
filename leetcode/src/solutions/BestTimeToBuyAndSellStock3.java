package solutions;

public class BestTimeToBuyAndSellStock3 {

	int maxProfit(int[] prices) {
		int len = prices.length;
		if (len < 2) {
			return 0;
		}
		int[] profitLeft = new int[len];
		for (int i = 1, min = prices[0]; i < len; ++i) {
			profitLeft[i] = Math.max(prices[i] - min, profitLeft[i - 1]);
			if (prices[i] < min) {
				min = prices[i];
			}
		}
		int[] profitRight = new int[len];
		for (int i = len - 2, max = prices[len - 1]; i >= 0; --i) {
			profitRight[i] = Math.max(max - prices[i], profitRight[i + 1]);
			if (prices[i] > max) {
				max = prices[i];
			}
		}
		int ret = profitRight[0];
		for (int i = 1, end = len - 2; i < end; ++i) {
			ret = Math.max(profitLeft[i] + profitRight[i + 1], ret);
		}
		return ret;
	}

}
