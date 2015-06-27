package solutions;

public class BitwiseANDOfNumbersRange {

	int rangeBitwiseAnd(int m, int n) {
		if (m > n) {
			return 0;
		}
		int ret = 0;
		for (int i = 0; i < Integer.SIZE; ++i) {
			if (m == n && (m & 1) == 1) {
				ret |= 1 << i;
			}
			m >>= 1;
			n >>= 1;
		}
		return ret;
	}

}
