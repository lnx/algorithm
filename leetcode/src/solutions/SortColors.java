package solutions;

public class SortColors {

	void sortColors(int[] a) {
		int red = -1, blue = a.length;
		for (int i = 0; i < blue;) {
			if (a[i] == 2) {
				swap(a, i, --blue);
			} else {
				if (a[i] == 0) {
					swap(a, i, ++red);
				}
				++i;
			}
		}
	}

	void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		SortColors obj = new SortColors();
		int[] a = { 1, 0, 1 };
		obj.sortColors(a);
		for (int num : a) {
			System.out.print(num + " ");
		}
	}

}
