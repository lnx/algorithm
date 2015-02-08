package practice.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import practice.SymmetricNumber;

public class SymmetricNumberTest {

	@Test
	public void testNextNumber() {
		SymmetricNumber o = new SymmetricNumber();
		for (int i = 0; i < 10000; ++i) {
			String message = String.format("test %d", i);
			String expected = mockNextNumber(i);
			String actual = o.nextNumber(i);
			assertEquals(message, expected, actual);
		}
	}

	String mockNextNumber(int n) {
		int i = n + 1;
		while (true) {
			String s = String.valueOf(i);
			if (isSymmetric(s)) {
				return s;
			}
			++i;
		}
	}

	boolean isSymmetric(String s) {
		if (s == null) {
			return false;
		}
		for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
