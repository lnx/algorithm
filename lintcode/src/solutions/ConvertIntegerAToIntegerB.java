package solutions;

public class ConvertIntegerAToIntegerB {

	static int bitSwapRequired(int a, int b) {
		a ^= b;
		int count = 0;
		for (int i = 0; i < Integer.SIZE; ++i) {
			if ((a & 1) != 0) {
				++count;
			}
			a >>= 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(bitSwapRequired(31, 14));
	}

}
