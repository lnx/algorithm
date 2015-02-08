package solutions;

public class ReverseWordsInAString {

	String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0;) {
			if (s.charAt(i) == ' ') {
				--i;
			} else {
				int j = i;
				while (j - 1 >= 0 && s.charAt(j - 1) != ' ') {
					--j;
				}
				sb.append(s.substring(j, i + 1) + " ");
				i = j - 1;
			}
		}
		return sb.toString().trim();
	}

}
