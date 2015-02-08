package sort;

public class InsertSort {

	void sort(int[] a) {
		for (int i = 1; i < a.length; ++i) {
			int cur = a[i];
			int j = i;
			while (j - 1 >= 0 && a[j - 1] > cur) {
				a[j] = a[--j];
			}
			a[j] = cur;
		}
	}

	public static void main(String[] args) {
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		new InsertSort().sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
