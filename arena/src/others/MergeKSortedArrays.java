package others;

import java.util.PriorityQueue;

public class MergeKSortedArrays {

	int[] merge(int[][] arrays) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>();
		for (int i = 0; i < arrays.length; ++i) {
			if (arrays[i].length > 0) {
				pq.offer(new ListNode(0, arrays[i]));
			}
		}
		int[] ret = new int[calSize(arrays)];
		for (int k = 0; !pq.isEmpty(); ++k) {
			ListNode node = pq.poll();
			ret[k] = node.val();
			ListNode next = node.next();
			if (next != null) {
				pq.offer(next);
			}
		}
		return ret;
	}

	int calSize(int[][] arrays) {
		int size = 0;
		for (int i = 0; i < arrays.length; ++i) {
			size += arrays[i].length;
		}
		return size;
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
		int[][] arrays = { { 1, 2, 3, 4 }, { 2, 3, 4 }, { 1, 5, 6 } };
		int[] ret = new MergeKSortedArrays().merge(arrays);
		for (int i : ret) {
			System.out.printf("%d ", i);
		}
	}

}
