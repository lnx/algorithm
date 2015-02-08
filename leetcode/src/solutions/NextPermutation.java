package solutions;

public class NextPermutation {

	void nextPermutation(int[] num) {
		int i = num.length - 2;
		while (i >= 0 && num[i] >= num[i + 1]) {
			--i;
		}
		if (i >= 0) {
			int j = i + 1;
			while (j + 1 < num.length && num[j + 1] > num[i]) {
				++j;
			}
			swap(num, i, j);
			sort(num, i + 1, num.length - 1);
		} else {
			sort(num, 0, num.length - 1);
		}
	}

	void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	void sort(int[] num, int start, int end) {
		for (int i = start + 1; i <= end; ++i) {
			int cur = num[i];
			int j = i;
			while (j > start && num[j - 1] > cur) {
				num[j] = num[--j];
			}
			num[j] = cur;
		}
	}

	public static void main(String[] args) {
		NextPermutation obj = new NextPermutation();
		int[] num = { 2, 3, 1 };
		obj.nextPermutation(num);
		for (int n : num) {
			System.out.print(n + " ");
		}
	}

}
