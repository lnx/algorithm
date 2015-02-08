package solutions;

public class ReverseInteger {

	int reverse(int x) {
		int ret = 0, flag = x >= 0 ? 1 : -1;
		while (x != 0) {
			int cur = Math.abs(x % 10);
			if (flag > 0 && (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && cur >= 7))) {
				return 0;
			} else if (flag < 0 && (-ret < Integer.MIN_VALUE / 10 || (-ret == Integer.MIN_VALUE / 10 && cur >= 8))) {
				return 0;
			} else {
				ret = ret * 10 + cur;
			}
			x /= 10;
		}
		return ret * flag;
	}

}
