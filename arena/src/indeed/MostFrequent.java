package indeed;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostFrequent {

	int[] getTopK(int[][] arrays, int k) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>();
		for (int i = 0; i < arrays.length; ++i) {
			if (arrays[i].length > 0) {
				pq.offer(new ListNode(0, arrays[i]));
			}
		}
		Map<Integer, Integer> count = new HashMap<>();
		for (; !pq.isEmpty();) {
			ListNode node = pq.poll();
			count.put(node.val(), count.getOrDefault(node.val(), 0) + 1);
			ListNode next = node.next();
			if (next != null) {
				pq.offer(next);
			}
			if (count.size() > k) {
				// TODO
			}
		}
		return null;
	}

	class ListNode implements Comparable<ListNode> {

		int index;
		int[] array;

		ListNode(int index, int[] array) {
			this.index = index;
			this.array = array;
		}

		public int val() {
			return array[index];
		}

		public ListNode next() {
			if (index + 1 < array.length) {
				return new ListNode(index + 1, array);
			}
			return null;
		}

		public int compareTo(ListNode listNode) {
			return val() - listNode.val();
		}

	}

	public static void main(String[] args) {
		int[][] arrays = { { 1, 2, 2, 4 }, { 2, 2, 3, 4 }, { 1, 3, 3, 6 } };
		int[] ret = new MostFrequent().getTopK(arrays, 2);
		for (int i : ret) {
			System.out.printf("%d ", i);
		}
	}

}
