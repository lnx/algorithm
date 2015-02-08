package solutions;

public class ReverseWordsInAString {

	String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; --i) {
			if (s.charAt(i) != ' ') {
				int j = i + 1;
				while (i - 1 >= 0 && s.charAt(i - 1) != ' ') {
					--i;
				}
				sb.append(sb.length() == 0 ? s.substring(i, j) : " " + s.substring(i, j));
			}
		}
		return sb.toString();
	}

}
