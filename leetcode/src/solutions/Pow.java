package solutions;

public class Pow {

	double pow(double x, int n) {
		if (n < 0) {
			double ret = pow(x, n / -2);
			if (n % 2 == 0) {
				return 1 / (ret * ret);
			} else {
				return 1 / (ret * ret * x);
			}
		} else if (n == 0) {
			return 1;
		} else {
			double ret = pow(x, n / 2);
			if (n % 2 == 0) {
				return ret * ret;
			} else {
				return ret * ret * x;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Pow().pow(-1, -2147483647));
	}

}
