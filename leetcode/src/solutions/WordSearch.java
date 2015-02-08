package solutions;

public class WordSearch {

	boolean exist(char[][] board, String word) {
		int m = board.length, n = m > 0 ? board[0].length : 0;
		boolean[][] visit = new boolean[m][n];
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (exist(board, word, i, j, visit)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean exist(char[][] board, String word, int i, int j, boolean visit[][]) {
		if (word.length() == 0) {
			return true;
		} else {
			boolean ret = false;
			int m = board.length, n = board[0].length;
			if (i >= 0 && i < m && j >= 0 && j < n && !visit[i][j] && board[i][j] == word.charAt(0)) {
				visit[i][j] = true;
				String sub = word.substring(1);
				ret = exist(board, sub, i + 1, j, visit) || exist(board, sub, i - 1, j, visit) || exist(board, sub, i, j + 1, visit) || exist(board, sub, i, j - 1, visit);
				visit[i][j] = false;
			}
			return ret;
		}
	}

	public static void main(String[] args) {
		char[][] board = { { 'a', 'a' } };
		String word = "aa";
		System.out.println(new WordSearch().exist(board, word));
	}

}
