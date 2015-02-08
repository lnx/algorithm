package solutions;

import struct.ListNode;

public class RemoveDuplicatesFromSortedList2 {

	static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			if (pre.next.val == pre.next.next.val) {
				ListNode cur = pre.next.next.next;
				while (cur != null && cur.val == pre.next.val) {
					cur = cur.next;
				}
				pre.next = cur;
			} else {
				pre = pre.next;
			}
		}
		return dummy.next;
	}

}
