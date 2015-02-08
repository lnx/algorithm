package solutions;

import struct.ListNode;

public class IntersectionOfTwoLinkedLists {

	ListNode getIntersectionNode(ListNode h1, ListNode h2) {
		if (h1 == null || h2 == null) {
			return null;
		}
		int len1 = 1;
		ListNode last1 = h1;
		while (last1.next != null) {
			last1 = last1.next;
			++len1;
		}
		int len2 = 1;
		ListNode last2 = h2;
		while (last2.next != null) {
			last2 = last2.next;
			++len2;
		}
		if (last1 != last2) {
			return null;
		}
		ListNode cur1 = h1, cur2 = h2;
		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; ++i) {
				cur1 = cur1.next;
			}
		} else if (len1 < len2) {
			for (int i = 0; i < len2 - len1; ++i) {
				cur2 = cur2.next;
			}
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

}
