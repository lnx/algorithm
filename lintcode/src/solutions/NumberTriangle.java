package solutions;

import java.util.ArrayList;

public class NumberTriangle {

	int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int size = triangle.size();
		int[] dp = new int[size];
		for (int i = 0; i < size; ++i) {
			dp[i] = triangle.get(size - 1).get(i);
		}
		for (int i = size - 1; i > 0; --i) {
			ArrayList<Integer> list = triangle.get(i - 1);
			for (int j = 0; j < i; ++j) {
				dp[j] = list.get(j) + Math.min(dp[j], dp[j + 1]);
			}
		}
		return dp[0];
	}

}
