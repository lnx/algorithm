package solutions;

public class RemoveDuplicatesFromSortedArray {

	int removeDuplicates(int[] a) {
		int dup = 0;
		for (int i = 1; i < a.length; ++i) {
			if (a[i] == a[i - dup - 1]) {
				++dup;
			} else {
				a[i - dup] = a[i];
			}
		}
		return a.length - dup;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 2 };
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		int length = obj.removeDuplicates(a);
		System.out.println(length);
		for (int i = 0; i < length; ++i) {
			System.out.print(a[i] + " ");
		}
	}

}
