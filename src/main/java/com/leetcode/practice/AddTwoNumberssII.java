package com.leetcode.practice;

import java.util.Stack;

public class AddTwoNumberssII {

	
	public static void main(String[] args) {
		
	}
	
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

	public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while (l1 != null && l2 != null) {
			s1.push(l1.val);
			s2.push(l2.val);
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		ListNode head = null, node = null;

		head = new ListNode();

		node = head;

		int carry = 0;

		while (!s1.empty() && !s2.empty()) {
			int val1 = s1.pop();
			int val2 = s2.pop();

			if (node.next != null) {
				node = node.next;
			}

			node.val = (val1 + val2 + carry) % 10;
			carry = (val1 + val2 + carry) / 10;
			node.next = new ListNode();
		}

		while (!s1.empty()) {
			int val1 = s1.pop();
			node = node.next;
			node.val = (val1 + carry) % 10;
			carry = (val1 + carry) / 10;
			node.next = new ListNode();
		}

		while (!s2.empty()) {
			int val2 = s2.pop();

			node = node.next;

			node.val = (val2 + carry) % 10;
			carry = (val2 + carry) / 10;
			node.next = new ListNode();
		}

		if (carry > 0) {
			node = node.next;
			node.val = carry;
		}

		node.next = null;

		ListNode prev = null;

		node = head;

		ListNode current;

		while (node != null) {
			current = node;
			node = node.next;
			current.next = prev;
			prev = current;
		}

		return prev;
	}
}
