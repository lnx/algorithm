package solutions;

import struct.ListNode;

public class SortList {

	ListNode sortList(ListNode head) {
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		for (int k = 1, len = getLength(head); k < len; k *= 2) {
			ListNode newTail = newHead, head1 = move(newTail, 1), head2 = move(head1, k);
			while (head2 != null) {
				newTail.next = merge(head1, head2, k);
				newTail = move(newTail, k * 2);
				head1 = move(newTail, 1);
				head2 = move(head1, k);
			}
		}
		return newHead.next;
	}

	int getLength(ListNode node) {
		int len = 0;
		while (node != null) {
			node = node.next;
			++len;
		}
		return len;
	}

	ListNode move(ListNode node, int k) {
		for (int i = 0; i < k && node != null; ++i) {
			node = node.next;
		}
		return node;
	}

	ListNode merge(ListNode head1, ListNode head2, int k) {
		ListNode newHead = new ListNode(-1), newTail = newHead, behind = move(head2, k);
		int i = 0, j = 0;
		while (i < k && j < k && head2 != null) {
			if (head1.val < head2.val) {
				newTail.next = head1;
				head1 = head1.next;
				++i;
			} else {
				newTail.next = head2;
				head2 = head2.next;
				++j;
			}
			newTail = newTail.next;
		}
		while (i++ < k) {
			newTail.next = head1;
			head1 = head1.next;
			newTail = newTail.next;
		}
		while (j++ < k && head2 != null) {
			newTail.next = head2;
			head2 = head2.next;
			newTail = newTail.next;
		}
		newTail.next = behind;
		return newHead.next;
	}

}
