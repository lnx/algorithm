package solutions;

public class ZigZagConversion {

	String convert(String s, int rows) {
		StringBuilder sb = new StringBuilder();
		int interval = rows == 1 ? 1 : 2 * (rows - 1);
		for (int i = 0, len = s.length(); i < rows; ++i) {
			for (int j = i; j < len; j += interval) {
				sb.append(s.charAt(j));
				if (i > 0 && i < rows - 1) {
					int next = j + interval - 2 * i;
					if (next < len) {
						sb.append(s.charAt(next));
					}
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 1));
	}

}
