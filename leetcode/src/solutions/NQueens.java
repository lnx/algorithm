package solutions;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	List<String[]> solveNQueens(int n) {
		List<String[]> ret = new ArrayList<>();
		int[] pos = new int[n];
		dfs(n, 0, pos, ret);
		return ret;
	}

	void dfs(int n, int row, int[] pos, List<String[]> ret) {
		if (row == n) {
			String[] strs = new String[n];
			for (int i = 0; i < n; ++i) {
				strs[i] = generateLine(n, pos[i]);
			}
			ret.add(strs);
		} else {
			for (int col = 0; col < n; ++col) {
				if (!attack(row, col, pos)) {
					pos[row] = col;
					dfs(n, row + 1, pos, ret);
				}
			}
		}
	}

	String generateLine(int n, int col) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			sb.append('.');
		}
		sb.setCharAt(col, 'Q');
		return sb.toString();
	}

	boolean attack(int row, int col, int[] pos) {
		for (int i = 0; i < row; ++i) {
			if (col == pos[i] || row - i == Math.abs(col - pos[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		List<String[]> ansList = nq.solveNQueens(8);
		for (String[] ans : ansList) {
			for (String s : ans) {
				System.out.println(s);
			}
			System.out.println();
		}
	}

}
