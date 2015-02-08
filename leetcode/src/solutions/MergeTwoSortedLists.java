package solutions;

import struct.ListNode;

public class MergeTwoSortedLists {

	ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		ListNode newHead = new ListNode(-1);
		ListNode newTail = newHead;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				newTail.next = head1;
				head1 = head1.next;
			} else {
				newTail.next = head2;
				head2 = head2.next;
			}
			newTail = newTail.next;
		}
		if (head1 != null) {
			newTail.next = head1;
		}
		if (head2 != null) {
			newTail.next = head2;
		}
		return newHead.next;
	}

}
