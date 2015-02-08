package solutions;

import java.util.Arrays;

public class MaximumGap {

	int maximumGap(int[] num) {
		if (num.length < 2) {
			return 0;
		}
		int ret = 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i : num) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}
		int len = (int) Math.ceil((double) (max - min) / (num.length - 1));
		if (len > 0) {
			int blen = (max - min) / len + 1;
			int[] minBucket = new int[blen];
			int[] maxBucket = new int[blen];
			Arrays.fill(minBucket, Integer.MAX_VALUE);
			Arrays.fill(maxBucket, Integer.MIN_VALUE);
			for (int i : num) {
				int bi = (i - min) / len;
				if (i < minBucket[bi]) {
					minBucket[bi] = i;
				}
				if (i > maxBucket[bi]) {
					maxBucket[bi] = i;
				}
			}
			for (int i = 1, prev = 0; i < blen; ++i) {
				if (maxBucket[i] != Integer.MIN_VALUE) {
					int gap = minBucket[i] - maxBucket[prev];
					if (gap > ret) {
						ret = gap;
					}
					prev = i;
				}
			}
		}
		return ret;
	}

}
