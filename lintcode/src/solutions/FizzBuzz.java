package solutions;

import java.util.ArrayList;

public class FizzBuzz {

	ArrayList<String> fizzBuzz(int n) {
		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				ret.add("fizz buzz");
			} else if (i % 5 == 0) {
				ret.add("buzz");
			} else if (i % 3 == 0) {
				ret.add("fizz");
			} else {
				ret.add(String.valueOf(i));
			}
		}
		return ret;
	}

}
