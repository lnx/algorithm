package solutions;

import java.util.ArrayList;
import java.util.Stack;

public class NQueens {

	ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> ret = new ArrayList<>();
		search(n, new Stack<Integer>(), ret);
		return ret;
	}

	void search(int n, Stack<Integer> pos, ArrayList<ArrayList<String>> ret) {
		if (pos.size() == n) {
			ret.add(genPos(n, pos));
		} else {
			for (int col = 0; col < n; ++col) {
				if (!attack(pos, pos.size(), col)) {
					pos.push(col);
					search(n, pos, ret);
					pos.pop();
				}
			}
		}
	}

	boolean attack(Stack<Integer> pos, int row, int col) {
		for (int i = 0; i < pos.size(); ++i) {
			if (col == pos.get(i) || row - i == Math.abs(col - pos.get(i))) {
				return true;
			}
		}
		return false;
	}

	ArrayList<String> genPos(int n, Stack<Integer> pos) {
		ArrayList<String> ret = new ArrayList<>();
		for (int p : pos) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; ++i) {
				if (i == p) {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			ret.add(sb.toString());
		}
		return ret;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> ret = new NQueens().solveNQueens(8);
		for (ArrayList<String> lines : ret) {
			for (String line : lines) {
				System.out.println(line);
			}
			System.out.println();
		}
	}

}
