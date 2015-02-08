package solutions;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	boolean isValidSudoku(char[][] board) {
		return checkRow(board) && checkCol(board) && checkBlock(board);
	}

	boolean checkRow(char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < 9; ++i) {
			set.clear();
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] != '.' && set.contains(board[i][j])) {
					return false;
				}
				set.add(board[i][j]);
			}
		}
		return true;
	}

	boolean checkCol(char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int j = 0; j < 9; ++j) {
			set.clear();
			for (int i = 0; i < 9; ++i) {
				if (board[i][j] != '.' && set.contains(board[i][j])) {
					return false;
				}
				set.add(board[i][j]);
			}
		}
		return true;
	}

	boolean checkBlock(char[][] board) {
		Set<Character> set = new HashSet<>();
		for (int x = 0; x <= 6; x += 3) {
			for (int y = 0; y <= 6; y += 3) {
				set.clear();
				for (int i = x, isize = x + 3; i < isize; ++i) {
					for (int j = y, jsize = y + 3; j < jsize; ++j) {
						if (board[i][j] != '.' && set.contains(board[i][j])) {
							return false;
						}
						set.add(board[i][j]);
					}
				}
			}
		}
		return true;
	}

}
