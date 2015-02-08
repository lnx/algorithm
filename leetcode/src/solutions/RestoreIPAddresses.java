package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RestoreIPAddresses {

	List<String> restoreIpAddresses(String s) {
		List<String> ret = new ArrayList<>();
		restoreIpAddresses(s, new Stack<String>(), ret);
		return ret;
	}

	void restoreIpAddresses(String s, Stack<String> stack, List<String> ret) {
		if (stack.size() == 4) {
			if (s.equals("")) {
				ret.add(stack.get(0) + "." + stack.get(1) + "." + stack.get(2) + "." + stack.get(3));
			}
		} else {
			for (int i = 0, len = s.length(); i < 3 && i < len; ++i) {
				String digit = s.substring(0, i + 1);
				if (isValid(digit)) {
					stack.push(digit);
					restoreIpAddresses(s.substring(i + 1), stack, ret);
					stack.pop();
				}
			}
		}
	}

	boolean isValid(String digit) {
		if (digit.startsWith("0")) {
			return digit.length() == 1;
		} else {
			return Integer.parseInt(digit) <= 255;
		}
	}

	public static void main(String[] args) {
		List<String> ret = new RestoreIPAddresses().restoreIpAddresses("010010");
		for (String ip : ret) {
			System.out.println(ip);
		}
	}

}
