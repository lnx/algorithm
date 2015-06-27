package solutions;

public class NumberOf1Bits {

	static final int MAX_LENGTH = 32;

	int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < MAX_LENGTH; ++i) {
			if ((n & 1) == 1) {
				++count;
			}
			n >>= 1;
		}
		return count;
	}

}
