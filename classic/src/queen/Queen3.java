package queen;

import java.util.Arrays;

public class Queen3 {

	int num;
	int ans;
	int[] pos;

	Queen3(int n) {
		num = n;
		ans = 0;
		pos = new int[num];
		Arrays.fill(pos, -1);
		search();
	}

	void search() {
		int row = 0;
		while (row >= 0) {
			if (row == num) {
				++ans;
				--row;
			} else {
				if (pos[row] + 1 < num) {
					++pos[row];
					if (!attack(row, pos[row])) {
						++row;
					}
				} else {
					pos[row] = -1;
					--row;
				}
			}
		}
	}

	boolean attack(int row, int col) {
		for (int i = 0; i < row; ++i) {
			if (col == pos[i] || row - i == Math.abs(col - pos[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new Queen3(10).ans);
	}

}
