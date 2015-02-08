package sort;

public class MergeSort {

	void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	void sort(int[] a, int left, int right) {
		if (left < right) {
			int center = left + (right - left) / 2;
			sort(a, left, center);
			sort(a, center + 1, right);
			merge(a, left, center, right);
		}
	}

	void merge(int[] a, int left, int center, int right) {
		int len = right - left + 1;
		int[] temp = new int[len];
		int i = left, j = center + 1, k = 0;
		while (i <= center && j <= right) {
			temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
		}
		while (i <= center) {
			temp[k++] = a[i++];
		}
		while (j <= right) {
			temp[k++] = a[j++];
		}
		System.arraycopy(temp, 0, a, left, len);
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 };
		new MergeSort().sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
