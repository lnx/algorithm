package solutions;

public class CountAndSay {

	String countAndSay(int n) {
		StringBuilder ret = new StringBuilder("1");
		StringBuilder cur = new StringBuilder();
		for (int i = 0; i < n - 1; ++i) {
			cur.setLength(0);
			for (int j = 0, len = ret.length(); j < len;) {
				int k = 1;
				while (j + k < len && ret.charAt(j + k) == ret.charAt(j)) {
					++k;
				}
				cur.append(k);
				cur.append(ret.charAt(j));
				j += k;
			}
			ret.setLength(0);
			ret.append(cur);
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(5));
	}

}
