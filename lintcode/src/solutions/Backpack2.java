package solutions;

public class Backpack2 {

	int backPackII(int m, int[] a, int[] v) {
		int[] dp = new int[m + 1];
		for (int i = 1; i <= a.length; ++i) {
			for (int j = m; j >= 1; --j) {
				if (j >= a[i - 1]) {
					dp[j] = Math.max(dp[j], dp[j - a[i - 1]] + v[i - 1]);
				}
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
		int m = 10;
		int[] a = { 2, 3, 5, 7 }, v = { 1, 5, 2, 4 };
		System.out.println(new Backpack2().backPackII(m, a, v));
	}

}
