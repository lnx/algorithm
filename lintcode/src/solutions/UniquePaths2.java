package solutions;

public class UniquePaths2 {

	int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rows = obstacleGrid.length, cols = rows > 0 ? obstacleGrid[0].length : 0;
		int[] dp = new int[cols];
		for (int j = 0; j < cols; ++j) {
			if (obstacleGrid[0][j] == 1) {
				break;
			} else {
				dp[j] = 1;
			}
		}
		for (int i = 1; i < rows; ++i) {
			if (obstacleGrid[i][0] == 1) {
				dp[0] = 0;
			}
			for (int j = 1; j < cols; ++j) {
				if (obstacleGrid[i][j] == 1) {
					dp[j] = 0;
				} else {
					dp[j] += dp[j - 1];
				}
			}
		}
		return dp[cols - 1];
	}
	
}
