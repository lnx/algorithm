package solutions;

public class PlusOne {

	int[] plusOne(int[] digits) {
		boolean all9 = true;
		for (int i : digits) {
			if (i != 9) {
				all9 = false;
				break;
			}
		}
		if (all9) {
			int[] ret = new int[digits.length + 1];
			ret[0] = 1;
			return ret;
		} else {
			int carry = 1;
			for (int i = digits.length - 1; i >= 0; --i) {
				digits[i] += carry;
				carry = digits[i] / 10;
				digits[i] %= 10;
			}
			return digits;
		}
	}

}
