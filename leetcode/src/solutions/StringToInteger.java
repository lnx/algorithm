package solutions;

public class StringToInteger {

	int atoi(String s) {
		if (s == null) {
			return 0;
		}
		int ret = 0, flag = 1;
		char[] chs = s.trim().toCharArray();
		for (int i = 0; i < chs.length; ++i) {
			if (i == 0 && (chs[i] == '+' || chs[i] == '-')) {
				flag = chs[i] == '+' ? 1 : -1;
			} else if (chs[i] >= '0' && chs[i] <= '9') {
				if (flag > 0 && (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && chs[i] >= '7'))) {
					return Integer.MAX_VALUE;
				} else if (flag < 0 && (-ret < Integer.MIN_VALUE / 10 || (-ret == Integer.MIN_VALUE / 10 && chs[i] >= '8'))) {
					return Integer.MIN_VALUE;
				}
				ret = ret * 10 + (chs[i] - '0');
			} else {
				break;
			}
		}
		return ret * flag;
	}

	public static void main(String[] args) {
		System.out.println(new StringToInteger().atoi("2147483648"));
	}

}
