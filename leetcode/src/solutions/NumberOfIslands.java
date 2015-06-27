package solutions;

public class NumberOfIslands {

	int numIslands(char[][] grid) {
		int row = grid.length, col = row > 0 ? grid[0].length : 0;
		int count = 0;
		while (flood(grid, row, col) != 0) {
			++count;
		}
		return count;
	}

	int flood(char[][] grid, int row, int col) {
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (grid[i][j] == '1') {
					flood(grid, row, col, i, j);
					return 1;
				}
			}
		}
		return 0;
	}

	void flood(char[][] grid, int row, int col, int x, int y) {
		if (x >= 0 && x < row && y >= 0 && y < col) {
			if (grid[x][y] == '1') {
				grid[x][y] = 'f';
				flood(grid, row, col, x - 1, y);
				flood(grid, row, col, x, y + 1);
				flood(grid, row, col, x + 1, y);
				flood(grid, row, col, x, y - 1);
			}
		}
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '0' } };
		System.out.println(new NumberOfIslands().numIslands(grid));
	}

}
