package solutions;

public class Backpack {

	int backPack(int m, int[] a) {
		int[] dp = new int[m + 1];
		for (int i = 1; i <= a.length; ++i) {
			for (int j = m; j >= 1; --j) {
				if (j >= a[i - 1]) {
					dp[j] = Math.max(dp[j], dp[j - a[i - 1]] + a[i - 1]);
				}
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
		int m = 12;
		int[] a = { 2, 3, 5, 7 };
		System.out.println(new Backpack().backPack(m, a));
	}

}
