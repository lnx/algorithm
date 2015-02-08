package sort;

public class QuickSort {

	static final int CUTOFF = 5;

	void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	void sort(int[] a, int left, int right) {
		if (right - left + 1 >= CUTOFF) {
			int pivot = findPivot(a, left, right);
			int i = left;
			int j = right - 1;
			while (true) {
				while (a[++i] < pivot)
					;
				while (a[--j] > pivot)
					;
				if (i < j) {
					swap(a, i, j);
				} else {
					break;
				}
			}
			swap(a, i, right - 1);
			sort(a, left, i - 1);
			sort(a, i + 1, right);
		} else {
			insertSort(a, left, right);
		}
	}

	int findPivot(int[] a, int left, int right) {
		int center = left + (right - left) / 2;
		if (a[left] > a[center]) {
			swap(a, left, center);
		}
		if (a[left] > a[right]) {
			swap(a, left, right);
		}
		if (a[center] > a[right]) {
			swap(a, center, right);
		}
		swap(a, center, right - 1);
		return a[right - 1];
	}

	void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	void insertSort(int[] a, int left, int right) {
		for (int i = left + 1; i <= right; ++i) {
			int cur = a[i];
			int j = i;
			while (j > left && a[j - 1] > cur) {
				a[j] = a[--j];
			}
			a[j] = cur;
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		new QuickSort().sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
