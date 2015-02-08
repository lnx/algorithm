package solutions;

public class ExcelSheetColumnNumber {

	int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int ret = 0;
		for (int i = s.length() - 1, base = 1; i >= 0; --i) {
			ret += base * (s.charAt(i) - 'A' + 1);
			base *= 26;
		}
		return ret;
	}

}
