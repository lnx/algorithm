package solutions;

import struct.ListNode;

public class InsertionSortList {

	ListNode insertionSortList(ListNode head) {
		ListNode newHead = new ListNode(-1);
		while (head != null) {
			ListNode next = head.next;
			ListNode cur = newHead;
			while (cur.next != null && cur.next.val < head.val) {
				cur = cur.next;
			}
			head.next = cur.next;
			cur.next = head;
			head = next;
		}
		return newHead.next;
	}

}
