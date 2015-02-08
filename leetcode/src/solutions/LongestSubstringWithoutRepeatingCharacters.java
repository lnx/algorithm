package solutions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	int lengthOfLongestSubstring(String s) {
		int ret = 0;
		Set<Character> window = new HashSet<>();
		for (int front = 0, rear = 0, slen = s.length(); rear < slen;) {
			char r = s.charAt(rear++);
			if (window.contains(r)) {
				while (s.charAt(front) != r) {
					window.remove(s.charAt(front++));
				}
				++front;
			} else {
				window.add(r);
				ret = Math.max(window.size(), ret);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
		String str = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lswrc.lengthOfLongestSubstring(str));
	}

}
