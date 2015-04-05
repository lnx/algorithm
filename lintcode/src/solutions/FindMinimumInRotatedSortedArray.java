package solutions;

public class FindMinimumInRotatedSortedArray {

	int findMin(int[] num) {
		int left = 0, right = num.length - 1;
		while (left < right && num[left] >= num[right]) {
			int center = left + (right - left) / 2;
			if (num[left] <= num[center]) {
				left = center + 1;
			} else if (num[left] > num[center]) {
				right = center;
			}
		}
		return num[left];
	}

}
