package solutions;

public class ImplementStrStr {

	int strStr(String s, String p) {
		int slen = s.length(), plen = p.length();
		int[] next = getNext(p);
		int i = 0, j = 0;
		while (i < slen && j < plen) {
			if (j == -1 || s.charAt(i) == p.charAt(j)) {
				++i;
				++j;
			} else {
				j = next[j];
			}
		}
		return j == plen ? i - plen : -1;
	}

	int[] getNext(String p) {
		int len = p.length();
		int[] next = new int[len];
		if (len > 0) {
			next[0] = -1;
			int i = 0, k = -1;
			while (i < len - 1) {
				if (k == -1 || p.charAt(i) == p.charAt(k)) {
					next[++i] = ++k;
				} else {
					k = next[k];
				}
			}
		}
		return next;
	}

	public static void main(String[] args) {
		ImplementStrStr obj = new ImplementStrStr();
		System.out.println(obj.strStr("", ""));
	}

}
