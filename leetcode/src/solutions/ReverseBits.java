package solutions;

public class ReverseBits {

	int reverseBits(int n) {
		int ret = 0;
		for (int i = 0; i < Integer.SIZE; ++i) {
			int cur = (n >> i) & 1;
			if (cur != 0) {
				ret |= 1 << Integer.SIZE - i - 1;
			}
		}
		return ret;
	}

}
