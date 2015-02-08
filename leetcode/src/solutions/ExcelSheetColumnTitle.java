package solutions;

public class ExcelSheetColumnTitle {

	String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.insert(0, (char) ('A' + (n - 1) % 26));
			n = (n - 1) / 26;
		}
		return sb.toString();
	}

}
