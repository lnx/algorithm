package queen;

public class Queen2 {

	int num;
	int ans;
	int[] pos;

	Queen2(int n) {
		num = n;
		ans = 0;
		pos = new int[num];
		search(0);
	}

	void search(int row) {
		if (row < num) {
			for (int col = 0; col < num; ++col) {
				if (!attack(row, col)) {
					pos[row] = col;
					search(row + 1);
				}
			}
		} else {
			++ans;
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
		System.out.println(new Queen2(10).ans);
	}

}
