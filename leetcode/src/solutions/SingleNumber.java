package solutions;

public class SingleNumber {

	int singleNumber(int[] a) {
		int single = a[0];
		for (int i = 1; i < a.length; ++i) {
			single ^= a[i];
		}
		return single;
	}

}
