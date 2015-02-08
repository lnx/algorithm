package solutions;

import struct.ListNode;

public class AddTwoNumbers {

	ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(-1), newTail = newHead;
		int carry = 0;
		while (l1 != null) {
			if (l2 != null) {
				carry += l1.val + l2.val;
				l2 = l2.next;
			} else {
				carry += l1.val;
			}
			newTail.next = new ListNode(carry % 10);
			newTail = newTail.next;
			carry /= 10;
			l1 = l1.next;
		}
		while (l2 != null) {
			carry += l2.val;
			newTail.next = new ListNode(carry % 10);
			newTail = newTail.next;
			carry /= 10;
			l2 = l2.next;
		}
		if (carry > 0) {
			newTail.next = new ListNode(carry);
		}
		return newHead.next;
	}

}
