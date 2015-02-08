package solutions;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import struct.ListNode;

public class MergeKSortedLists {

	ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}
		Queue<ListNode> pq = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.val > n2.val) {
					return 1;
				} else if (n1.val == n2.val) {
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
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			cur.next = node;
			cur = node;
			if (node.next != null) {
				pq.offer(node.next);
			}
		}
		return dummy.next;
	}

}
