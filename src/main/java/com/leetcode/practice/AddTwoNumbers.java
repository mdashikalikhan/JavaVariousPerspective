package com.leetcode.practice;

public class AddTwoNumbers {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode start = null, result = null;
		int carry = 0;
		while (l1 != null && l2 != null) {
			if (start == null) {
				result = new ListNode();
				start = result;
			} else {
				result = result.next;
			}
			result.val = (l1.val + l2.val + carry) % 10;
			carry = (l1.val + l2.val + carry) / 10;
			result.next = new ListNode();
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			result = result.next;
			result.val = (l1.val + carry) % 10;
			carry = (l1.val + carry) / 10;
			result.next = new ListNode();
			l1 = l1.next;
		}

		while (l2 != null) {
			result = result.next;
			result.val = (l2.val + carry) % 10;
			carry = (l2.val + carry) / 10;
			result.next = new ListNode();
			l2 = l2.next;
		}

		if (carry > 0) {
			result = result.next;
			result.val = carry;
		}

		result.next = null;

		return start;
	}
}
