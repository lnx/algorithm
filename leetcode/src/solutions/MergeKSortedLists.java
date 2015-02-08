package solutions;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import struct.ListNode;

public class MergeKSortedLists {

	ListNode mergeKLists(List<ListNode> lists) {
		ListNode head = new ListNode(-1);
		int size = lists.size();
		if (size > 0) {
			PriorityQueue<ListNode> pq = new PriorityQueue<>(size, new Comparator<ListNode>() {
				public int compare(ListNode a, ListNode b) {
					if (a.val > b.val) {
						return 1;
					} else if (a.val == b.val) {
						return 0;
					} else {
						return -1;
					}
				}
			});
			for (ListNode node : lists) {
				if (node != null) {
					pq.offer(node);
				}
			}
			ListNode tail = head;
			while (pq.size() > 0) {
				tail.next = pq.poll();
				tail = tail.next;
				if (tail.next != null) {
					pq.offer(tail.next);
				}
			}
		}
		return head.next;
	}

}
