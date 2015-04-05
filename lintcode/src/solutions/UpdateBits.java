package solutions;

public class UpdateBits {

	int updateBits(int n, int m, int i, int j) {
		for (int k = i; k <= j; ++k) {
			if (((1 << k - i) & m) == 0) {
				n &= ~(1 << k);
			} else {
				n |= 1 << k;
			}
		}
		return n;
	}

}
