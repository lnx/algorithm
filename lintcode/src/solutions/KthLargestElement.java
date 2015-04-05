package solutions;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

	int kthLargestElement(int k, ArrayList<Integer> nums) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < k; ++i) {
			queue.offer(nums.get(i));
		}
		for (int i = k; i < nums.size(); ++i) {
			int n = nums.get(i);
			if (n > queue.peek()) {
				queue.poll();
				queue.offer(n);
			}
		}
		return queue.peek();
	}

}
