package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Equation {

	static final String INVALID = "Invalid";

	static void printEquation0(int[] a, int target) {
		if (a.length < 1 || a.length == 1 && a[0] != target) {
			System.out.println(INVALID);
		} else {
			for (int i = 0, size = (int) Math.pow(2, a.length - 1); i < size; ++i) {
				char[] chs = new char[a.length];
				for (int j = a.length - 1, cur = i; j >= 1; --j) {
					chs[j] = cur % 2 == 0 ? '+' : '-';
					cur >>= 2;
				}
				int sum = getSum(a, chs);
				if (sum == target) {
					String equation = getEquation(a, target, chs);
					System.out.println(equation);
					return;
				}
			}
			System.out.println(INVALID);
		}
	}

	static void printEquation1(int[] a, int target) {
		if (a.length < 1 || a.length == 1 && a[0] != target) {
			System.out.println(INVALID);
		} else {
			char[] chs = new char[a.length];
			Arrays.fill(chs, '.');
			int i = 1;
			while (i >= 1) {
				if (i == a.length) {
					int sum = getSum(a, chs);
					if (sum == target) {
						String equation = getEquation(a, target, chs);
						System.out.println(equation);
						return;
					} else {
						--i;
					}
				} else {
					if (chs[i] == '.') {
						chs[i++] = '+';
					} else if (chs[i] == '+') {
						chs[i++] = '-';
					} else {
						chs[i--] = '.';
					}
				}
			}
			System.out.println(INVALID);
		}
	}

	static int getSum(int[] a, char[] chs) {
		int sum = a[0];
		for (int j = 1; j < a.length; ++j) {
			if (chs[j] == '+') {
				sum += a[j];
			} else {
				sum -= a[j];
			}
		}
		return sum;
	}

	static String getEquation(int[] a, int target, char[] chs) {
		StringBuilder sb = new StringBuilder();
		sb.append(a[0]);
		for (int j = 1; j < a.length; ++j) {
			sb.append(String.format("%c%d", chs[j], a[j]));
		}
		return String.format("%s=%d", sb, target);
	}

	static void printEquation2(int[] a, int target) {
		if (a.length < 1 || a.length == 1 && a[0] != target) {
			System.out.println(INVALID);
		} else {
			List<List<Character>> ret = new ArrayList<>();
			search(a, target, a[0], new Stack<Character>(), ret);
			if (ret.size() > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append(a[0]);
				for (int i = 1; i < a.length; ++i) {
					sb.append(String.valueOf(ret.get(0).get(i - 1)) + a[i]);
				}
				System.out.printf("%s=%d\n", sb, target);
			} else {
				System.out.println(INVALID);
			}
		}
	}

	static void search(int[] a, int target, int sum, Stack<Character> stack, List<List<Character>> ret) {
		if (stack.size() == a.length - 1) {
			if (sum == target) {
				ret.add(new ArrayList<>(stack));
			}
		} else {
			stack.push('+');
			search(a, target, sum + a[stack.size()], stack, ret);
			stack.pop();
			stack.push('-');
			search(a, target, sum - a[stack.size()], stack, ret);
			stack.pop();
		}
	}

	static String getEquation(int[] a, int target, Stack<Character> stack) {
		StringBuilder sb = new StringBuilder();
		sb.append(a[0]);
		for (int i = 1; i < a.length; ++i) {
			sb.append(String.format("%c%d", stack.get(i - 1), a[i]));
		}
		return String.format("%s=%d", sb, target);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<String> lines = new ArrayList<>();
		for (String line = s.nextLine(); !line.matches("[ \t]*"); line = s.nextLine()) {
			lines.add(line);
		}
		s.close();
		for (String line : lines) {
			String[] strs = line.trim().split("[ \t]+");
			if (strs.length < 2) {
				System.out.println(INVALID);
			} else {
				try {
					int[] a = new int[strs.length - 1];
					for (int i = 0; i < a.length; ++i) {
						a[i] = Integer.parseInt(strs[i]);
					}
					int target = Integer.parseInt(strs[strs.length - 1]);
					printEquation0(a, target);
					printEquation1(a, target);
					printEquation2(a, target);
				} catch (Exception e) {
					System.out.println(INVALID);
				}
			}
		}
	}

}
