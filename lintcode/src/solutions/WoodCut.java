package solutions;

public class WoodCut {

	int woodCut(int[] l, int k) {
		int min = 1, max = Integer.MIN_VALUE;
		for (int i : l) {
			max = Math.max(max, i);
		}
		int ret = 0;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			if (count(l, mid) >= k) {
				min = mid + 1;
				ret = mid;
			} else {
				max = mid - 1;
			}
		}
		return ret;
	}

	int count(int[] l, int len) {
		int sum = 0;
		for (int i : l) {
			sum += i / len;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] l = { 232, 124, 456 };
		int k = 7;
		System.out.println(new WoodCut().woodCut(l, k));
	}

}
