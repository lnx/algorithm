package solutions;

import struct.ListNode;

public class PartitionList {
	
    ListNode partition(ListNode head, int x) {
    	ListNode h1 = new ListNode(0), h2 = new ListNode(0), c1 = h1, c2 = h2;
    	while (head != null) {
    		if (head.val < x) {
    			c1.next = head;
    			c1 = head;
    		} else {
    			c2.next = head;
    			c2 = head;
    		}
			head = head.next;
    	}
    	c1.next = h2.next;
    	c2.next = null;
    	return h1.next;
    }

}
