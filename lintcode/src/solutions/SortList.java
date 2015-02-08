package solutions;

import struct.ListNode;

public class SortList {

	ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMid(head);
		ListNode h2 = sortList(mid.next);
		mid.next = null;
		ListNode h1 = sortList(head);
		return merge(h1, h2);
	}

	ListNode findMid(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	ListNode merge(ListNode h1, ListNode h2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				cur.next = h1;
				h1 = h1.next;
			} else {
				cur.next = h2;
				h2 = h2.next;
			}
			cur = cur.next;
		}
		if (h1 != null) {
			cur.next = h1;
		}
		if (h2 != null) {
			cur.next = h2;
		}
		return dummy.next;
	}

}
