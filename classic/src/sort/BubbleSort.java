package sort;

public class BubbleSort {

	void sort(int[] a) {
		for (int i = a.length - 1; i > 0; --i) {
			boolean swap = false;
			for (int j = 0; j < i; ++j) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		new BubbleSort().sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
