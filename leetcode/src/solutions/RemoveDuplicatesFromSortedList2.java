package solutions;

import struct.ListNode;

public class RemoveDuplicatesFromSortedList2 {

	ListNode deleteDuplicates(ListNode head) {
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		ListNode cur = newHead;
		while (cur.next != null) {
			boolean dup = false;
			while (cur.next.next != null && cur.next.next.val == cur.next.val) {
				dup = true;
				cur.next.next = cur.next.next.next;
			}
			if (dup) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return newHead.next;
	}

}
