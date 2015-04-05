package solutions;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {

	int totalNQueens(int n) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(0);
		search(n, 0, new int[n], ret);
		return ret.get(0);
	}

	void search(int n, int row, int[] pos, List<Integer> ret) {
		if (row == n) {
			ret.set(0, ret.get(0) + 1);
		} else {
			for (int col = 0; col < n; ++col) {
				if (!attack(pos, row, col)) {
					pos[row] = col;
					search(n, row + 1, pos, ret);
				}
			}
		}
	}

	boolean attack(int[] pos, int row, int col) {
		for (int i = 0; i < row; ++i) {
			if (col == pos[i] || row - i == Math.abs(col - pos[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new NQueens2().totalNQueens(8));
	}

}
