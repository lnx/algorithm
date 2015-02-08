package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	static final char MARK = '-';

	class Pos {

		final int m, n;

		Pos(int row, int col) {
			this.m = row;
			this.n = col;
		}

	}

	void solve(char[][] board) {
		int rows = board.length, cols = rows > 0 ? board[0].length : 0;
		Queue<Pos> queue = new LinkedList<>();
		for (int i = 0; i < rows; ++i) {
			if (board[i][0] == 'O') {
				queue.offer(new Pos(i, 0));
				board[i][0] = MARK;
			}
			if (board[i][cols - 1] == 'O') {
				queue.offer(new Pos(i, cols - 1));
				board[i][cols - 1] = MARK;
			}
		}
		for (int j = 0; j < cols; ++j) {
			if (board[0][j] == 'O') {
				queue.offer(new Pos(0, j));
				board[0][j] = MARK;
			}
			if (board[rows - 1][j] == 'O') {
				queue.add(new Pos(rows - 1, j));
				board[rows - 1][j] = MARK;
			}
		}
		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			check(board, rows, cols, p.m + 1, p.n, queue);
			check(board, rows, cols, p.m - 1, p.n, queue);
			check(board, rows, cols, p.m, p.n + 1, queue);
			check(board, rows, cols, p.m, p.n - 1, queue);
		}
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				board[i][j] = board[i][j] == MARK ? 'O' : 'X';
			}
		}
	}

	void check(char[][] board, int rows, int cols, int m, int n, Queue<Pos> queue) {
		if (m >= 0 && m < rows && n >= 0 && n < cols && board[m][n] == 'O') {
			queue.offer(new Pos(m, n));
			board[m][n] = MARK;
		}
	}

}
