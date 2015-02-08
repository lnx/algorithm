package solutions;

import struct.ListNode;

public class PartitionList {

	ListNode partition(ListNode head, int x) {
		ListNode head1 = new ListNode(-1);
		ListNode head2 = new ListNode(-1);
		ListNode tail1 = head1;
		ListNode tail2 = head2;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				tail1.next = cur;
				tail1 = tail1.next;
			} else {
				tail2.next = cur;
				tail2 = tail2.next;
			}
			cur = cur.next;
		}
		tail1.next = head2.next;
		tail2.next = null;
		return head1.next;
	}

}
