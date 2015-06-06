package count;

import java.util.Random;

public class BitCount {

	static final int TSIZE = 2 << 16;

	static int[] LOOKUP = new int[TSIZE];

	static {
		for (int i = 0; i < TSIZE; ++i) {
			LOOKUP[i] = count1(i);
		}
	}

	/**
	 * ordinary
	 * 
	 * @param n
	 * @return
	 */
	static int count1(int n) {
		int c = 0;
		int i = n & -n;
		while (i != 0) {
			n ^= i;
			i = n & -n;
			++c;
		}
		return c;
	}

	/**
	 * lookup table
	 * 
	 * @param n
	 * @return
	 */
	static int count2(int n) {
		int c = 0;
		int bits = 16;
		int mask = (1 << bits) - 1;
		for (int i = 0, size = Integer.SIZE / bits; i < size; ++i) {
			c += LOOKUP[n & mask];
			n >>= bits;
		}
		return c;
	}

	public static void main(String[] args) {
		int size = 50_000_000;
		int[] a1 = new int[size];
		int[] a2 = new int[size];

		long t1 = System.currentTimeMillis();
		for (int i = 0; i < size; ++i) {
			a1[i] = count1(i);
		}
		t1 = System.currentTimeMillis() - t1;

		long t2 = System.currentTimeMillis();
		for (int i = 0; i < size; ++i) {
			a2[i] = count2(i);
		}
		t2 = System.currentTimeMillis() - t2;

		int rd = new Random().nextInt(65536);
		System.out.printf("c1: %d, t1: %d\n", a1[rd], t1);
		System.out.printf("c2: %d, t2: %d\n", a2[rd], t2);
	}

}
