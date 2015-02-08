package solutions;

import java.util.Arrays;

public class UniquePaths2 {

	int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = m > 0 ? obstacleGrid[0].length : 0;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; ++i) {
			if (obstacleGrid[0][i] == 1) {
				for (int j = i; j < n; ++j) {
					dp[j] = 0;
				}
				break;
			}
		}
		for (int i = 1; i < m; ++i) {
			if (obstacleGrid[i][0] == 1) {
				dp[0] = 0;
			}
			for (int j = 1; j < n; ++j) {
				if (obstacleGrid[i][j] == 1) {
					dp[j] = 0;
				} else {
					dp[j] += dp[j - 1];
				}
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0 }, { 0, 0 } };
		System.out.println(new UniquePaths2().uniquePathsWithObstacles(obstacleGrid));
	}

}
