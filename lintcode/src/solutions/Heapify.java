package solutions;

public class Heapify {

	void heapify(int[] a) {
		for (int i = a.length / 2; i >= 0; --i) {
			down(a, i, a.length);
		}
	}

	void down(int[] a, int i, int len) {
		int top = a[i];
		for (int child = i * 2 + 1; child < len; child = 2 * i + 1) {
			if (child + 1 < len && a[child] > a[child + 1]) {
				++child;
			}
			if (top > a[child]) {
				a[i] = a[child];
				i = child;
			} else {
				break;
			}
		}
		a[i] = top;
	}

}
