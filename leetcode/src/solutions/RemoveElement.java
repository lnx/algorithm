package solutions;

public class RemoveElement {

	int removeElement(int[] a, int v) {
		int len = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != v) {
				a[len++] = a[i];
			}
		}
		return len;
	}

}
