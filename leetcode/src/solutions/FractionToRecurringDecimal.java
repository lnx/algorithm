package solutions;

import java.util.ArrayList;
import java.util.List;

public class FractionToRecurringDecimal {
	
	String fractionToDecimal(int numerator, int denominator) {
		List<Long> reminder = new ArrayList<>();
		List<Long> result = new ArrayList<>();
		boolean negative = (double) numerator / denominator < 0;
		long a = Math.abs((long) numerator);
		long b = Math.abs((long) denominator);
		long cur = a % b;
		while (cur != 0 && !reminder.contains(cur)) {
			reminder.add(cur);
			result.add(cur * 10 / b);
			cur = cur * 10 % b;
		}
		StringBuilder sb = new StringBuilder();
		if (negative) {
			sb.append('-');
		}
		sb.append(a / b);
		if (result.size() > 0) {
			sb.append(".");
			if (cur == 0) {
				for (long i : result) {
					sb.append(i);
				}
			} else {
				int index = reminder.indexOf(cur);
				for (int i = 0; i < index; ++i) {
					sb.append(result.get(i));
				}
				sb.append('(');
				for (int i = index; i < result.size(); ++i) {
					sb.append(result.get(i));
				}
				sb.append(')');
			}
		}
		return sb.toString();
	}

}
