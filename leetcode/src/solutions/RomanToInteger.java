package solutions;

public class RomanToInteger {

	int romanToInt(String s) {
		int ret = 0;
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length;) {
			if (i + 1 < chs.length && charToInt(chs[i]) < charToInt(chs[i + 1])) {
				ret += charToInt(chs[i + 1]) - charToInt(chs[i]);
				i += 2;
			} else {
				ret += charToInt(chs[i++]);
			}
		}
		return ret;
	}

	int charToInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt("DCXXI"));
	}

}
