package amazon;

public class SymmetricNumber {

	public String nextNumber(int n) {
		if (n < 0) {
			return "";
		}
		if (n >= 0 && n < 9) {
			return String.valueOf(n + 1);
		}
		String source = String.valueOf(n);
		if (source.matches("9+")) {
			return String.valueOf(n + 2);
		}
		int len = source.length();
		if (isEven(len)) {
			String s1 = source.substring(0, len / 2);
			String s2 = source.substring(len / 2);
			if (reverse(s1).compareTo(s2) > 0) {
				return s1 + reverse(s1);
			} else {
				String s3 = String.valueOf(Integer.parseInt(s1) + 1);
				return s3 + reverse(s3);
			}
		} else {
			String s1 = source.substring(0, len / 2 + 1);
			String s2 = source.substring(len / 2);
			if (reverse(s1).compareTo(s2) > 0) {
				return s1 + reverse(s1).substring(1);
			} else {
				String s3 = String.valueOf(Integer.parseInt(s1) + 1);
				return s3 + reverse(s3).substring(1);
			}
		}
	}

	boolean isEven(int n) {
		return n % 2 == 0;
	}

	String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

}
