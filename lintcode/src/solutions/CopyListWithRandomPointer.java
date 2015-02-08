package solutions;

import struct.RandomListNode;

public class CopyListWithRandomPointer {

	RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode next = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		cur = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode dummyCur = dummy;
		while (cur != null) {
			RandomListNode next = cur.next.next;
			dummyCur.next = cur.next;
			dummyCur = dummyCur.next;
			cur.next = next;
			cur = next;
		}
		return dummy.next;
	}

}
