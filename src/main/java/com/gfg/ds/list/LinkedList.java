package com.gfg.ds.list;

public class LinkedList {

	public Node head;
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
		
	}
	

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		Node nodeFirst = new LinkedList.Node(1);
		Node nodeSecond = new LinkedList.Node(2);
		Node nodeThird = new LinkedList.Node(3);
		linkedList.head = nodeFirst;
		nodeFirst.next = nodeSecond;
		nodeSecond.next = nodeThird;
		
	}

}
