package solutions;

public class SingleNumber2 {

	int singleNumber(int[] a) {
		int ret = 0;
		for (int i = 0; i < Integer.SIZE; ++i) {
			int sum = 0, mask = 1 << i;
			for (int num : a) {
				if ((num & mask) != 0) {
					++sum;
				}
			}
			if (sum % 3 != 0) {
				ret |= mask;
			}
		}
		return ret;
	}

}
