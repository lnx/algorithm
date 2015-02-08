package solutions;

public class DivideTwoIntegers {

	int divide(int dividend, int divisor) {
		int ret = 0;
		long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
		while (a >= b) {
			long sub = b;
			long cnt = 1;
			while (a >= (sub << 1)) {
				sub <<= 1;
				cnt <<= 1;
			}
			a -= sub;
			ret += cnt;
		}
		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			return ret;
		} else {
			return -ret;
		}
	}

	public static void main(String[] args) {
		DivideTwoIntegers obj = new DivideTwoIntegers();
		System.out.println(obj.divide(-1010369383, -2147483648));
	}

}
