package solutions;

import struct.ListNode;

public class RemoveDuplicatesFromSortedList {

	ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.next.val == cur.val) {
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
		return head;
	}

}
