package solutions;

public class SudokuSolver {

	void solveSudoku(char[][] board) {
		search(board);
	}

	boolean search(char[][] board) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; ++c) {
						board[i][j] = c;
						if (check(board, i, j) && search(board)) {
							return true;
						}
					}
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}

	boolean check(char[][] board, int x, int y) {
		for (int i = 0; i < 9; ++i) {
			if (i != x && board[i][y] == board[x][y]) {
				return false;
			}
		}
		for (int j = 0; j < 9; ++j) {
			if (j != y && board[x][j] == board[x][y]) {
				return false;
			}
		}
		for (int i = x / 3 * 3; i < (x / 3 + 1) * 3; ++i) {
			for (int j = y / 3 * 3; j < (y / 3 + 1) * 3; ++j) {
				if ((i != x || j != y) && board[i][j] == board[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

}
