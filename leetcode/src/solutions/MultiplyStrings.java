package solutions;

public class MultiplyStrings {

	String multiply(String s1, String s2) {
		if (s1 == null || !s1.matches("\\d+") || s2 == null || !s2.matches("\\d+")) {
			return null;
		}
		int len1 = s1.length(), len2 = s2.length();
		int[] ret = new int[len1 + len2];
		int[] a1 = getArray(s1), a2 = getArray(s2);
		for (int i = 0; i < len1; ++i) {
			for (int j = 0; j < len2; ++j) {
				ret[i + j] += a1[i] * a2[j];
			}
		}
		for (int i = 0, carry = 0; i < ret.length; ++i) {
			ret[i] += carry;
			carry = ret[i] / 10;
			ret[i] %= 10;
		}
		int i = ret.length - 1;
		while (i > 0 && ret[i] == 0) {
			--i;
		}
		StringBuilder sb = new StringBuilder();
		while (i >= 0) {
			sb.append(ret[i--]);
		}
		return sb.toString();
	}

	int[] getArray(String s) {
		int len = s.length();
		int[] a = new int[len];
		for (int i = 0; i < len; ++i) {
			a[i] = s.charAt(len - i - 1) - '0';
		}
		return a;
	}

}
