package org.example.fastAndSlowPointer;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) return false;

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false; // fast reached the end => no cycle
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return true; // slow == fast => cycle detected
	}

	// Definition for singly-linked list
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Simple test
	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2; // cycle here!

		LinkedListCycle solution = new LinkedListCycle();
		System.out.println(solution.hasCycle(node1)); // Output: true
	}
}