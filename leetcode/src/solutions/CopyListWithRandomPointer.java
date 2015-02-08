package solutions;

import struct.RandomListNode;

public class CopyListWithRandomPointer {

	RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode node = new RandomListNode(cur.label);
			node.next = cur.next;
			cur.next = node;
			cur = cur.next.next;
		}
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		RandomListNode newHead = new RandomListNode(-1);
		RandomListNode tail = newHead;
		cur = head;
		while (cur != null) {
			tail.next = cur.next;
			tail = tail.next;
			cur.next = cur.next.next;
			cur = cur.next;
		}
		return newHead.next;
	}

}
