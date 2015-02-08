package solutions;

import java.util.Stack;

public class SimplifyPath {

	String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		for (int i = 0, len = path.length(); i < len;) {
			char c = path.charAt(i);
			if (c != '/') {
				int j = i;
				while (++j < len && path.charAt(j) != '/')
					;
				String s = path.substring(i, j);
				if (!s.equals(".")) {
					if (s.equals("..")) {
						if (!stack.isEmpty()) {
							stack.pop();
						}
					} else {
						stack.push(s);
					}
				}
				i = j;
			} else {
				++i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String s : stack) {
			sb.append("/" + s);
		}
		if (sb.length() == 0) {
			sb.append("/");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new SimplifyPath().simplifyPath("/abc/..."));
	}

}
