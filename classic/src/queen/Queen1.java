package queen;

public class Queen1 {

	int num;
	int ans;
	int limit;

	Queen1(int n) {
		num = n;
		ans = 0;
		limit = (1 << num) - 1;
		search(0, 0, 0);
	}

	void search(int row, int ld, int rd) {
		if (row != limit) {
			int pos = limit & ~(row | ld | rd);
			while (pos != 0) {
				int p = pos & -pos;
				search(row + p, (ld + p) << 1, (rd + p) >> 1);
				pos -= p;
			}
		} else {
			++ans;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Queen1(10).ans);
	}

}
