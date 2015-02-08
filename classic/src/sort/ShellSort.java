package sort;

public class ShellSort {

	void sort(int[] a) {
		for (int inc = a.length / 2; inc > 0; inc /= 2) {
			for (int i = inc; i < a.length; i += inc) {
				int cur = a[i];
				int j = i;
				while (j - inc >= 0 && a[j - inc] > cur) {
					a[j] = a[j - inc];
					j -= inc;
				}
				a[j] = cur;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		new ShellSort().sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

}
