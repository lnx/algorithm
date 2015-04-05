package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median {

	int median0(int[] nums) {
		Queue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Queue<Integer> min = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		for (int i : nums) {
			if (min.size() > 0 && i > min.peek()) {
				min.offer(i);
			} else {
				max.offer(i);
			}
			if (max.size() - min.size() == 2) {
				min.offer(max.poll());
			} else if (min.size() > max.size()) {
				max.offer(min.poll());
			}
		}
		return max.peek();
	}

	int median1(int[] nums) {
		int len1 = 0, len2 = 0;
		int[] max = new int[nums.length / 2 + 1], min = new int[nums.length / 2 + 1];
		for (int i : nums) {
			if (len2 > 0 && i > min[0]) {
				minAdd(min, len2++, i);
			} else {
				maxAdd(max, len1++, i);
			}
			if (len1 - len2 == 2) {
				minAdd(min, len2++, maxDel(max, 0, len1--));
			} else if (len2 > len1) {
				maxAdd(max, len1++, minDel(min, 0, len2--));
			}
		}
		return max[0];
	}

	void maxAdd(int[] a, int i, int num) {
		for (int parent = (i - 1) / 2; parent >= 0 && i > parent; parent = (i - 1) / 2) {
			if (num > a[parent]) {
				a[i] = a[parent];
				i = parent;
			} else {
				break;
			}
		}
		a[i] = num;
	}

	int maxDel(int[] a, int i, int len) {
		int ret = a[0];
		swap(a, 0, len-- - 1);
		int top = a[i];
		for (int child = 2 * i + 1; child < len; child = 2 * i + 1) {
			if (child + 1 < len && a[child] < a[child + 1]) {
				++child;
			}
			if (top < a[child]) {
				a[i] = a[child];
				i = child;
			} else {
				break;
			}
		}
		a[i] = top;
		return ret;
	}

	void minAdd(int[] a, int i, int num) {
		for (int parent = (i - 1) / 2; parent >= 0 && i > parent; parent = (i - 1) / 2) {
			if (num < a[parent]) {
				a[i] = a[parent];
				i = parent;
			} else {
				break;
			}
		}
		a[i] = num;
	}

	int minDel(int[] a, int i, int len) {
		int ret = a[0];
		swap(a, 0, len-- - 1);
		int top = a[i];
		for (int child = 2 * i + 1; child < len; child = 2 * i + 1) {
			if (child + 1 < len && a[child + 1] < a[child]) {
				++child;
			}
			if (top > a[child]) {
				a[i] = a[child];
				i = child;
			} else {
				break;
			}
		}
		a[i] = top;
		return ret;
	}

	void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		Median m = new Median();
		int[] a = { 5, -10, 4 };
		System.out.println(m.median0(a));
		System.out.println(m.median1(a));
	}

}
