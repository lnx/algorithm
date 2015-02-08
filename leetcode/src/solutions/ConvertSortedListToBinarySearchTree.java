package solutions;

import struct.ListNode;
import struct.TreeNode;

public class ConvertSortedListToBinarySearchTree {

	TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode prev = null, slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		if (prev != null) {
			prev.next = null;
			root.left = sortedListToBST(head);
		}
		root.right = sortedListToBST(slow.next);
		return root;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		System.out.println(new ConvertSortedListToBinarySearchTree().sortedListToBST(head));
	}

}
