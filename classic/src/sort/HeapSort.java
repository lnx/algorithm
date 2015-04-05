package sort;

public class HeapSort {

	void sort(int[] a) {
		for (int i = a.length / 2; i >= 0; --i) {
			down(a, i, a.length);
		}
		for (int i = a.length - 1; i > 0; --i) {
			swap(a, 0, i);
			down(a, 0, i);
		}
	}

	void down(int[] a, int i, int len) {
		int top = a[i];
		for (int child = 2 * i + 1; child < len; child = 2 * i + 1) {
			if (child + 1 < len && a[child] < a[child + 1]) {
				++child;
			}
			if (top < a[child]) {
				a[i] = a[child];
				i = child;
			} else {
				break;
			}
		}
		a[i] = top;
	}

	void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		new HeapSort().sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
