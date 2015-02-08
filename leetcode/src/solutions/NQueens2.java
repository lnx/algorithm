package solutions;

public class NQueens2 {

	int num;
	int ans;
	int limit;

	int totalNQueens(int n) {
		num = n;
		ans = 0;
		limit = (1 << num) - 1;
		search(0, 0, 0);
		return ans;
	}

	void search(int row, int ld, int rd) {
		if (row != limit) {
			int available = limit & ~(row | ld | rd);
			while (available != 0) {
				int p = available & -available;
				available -= p;
				search(row + p, (ld + p) << 1, (rd + p) >> 1);
			}
		} else {
			++ans;
		}
	}

}
